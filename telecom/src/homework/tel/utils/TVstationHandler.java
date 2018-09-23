package homework.tel.utils;




import homework.tel.entity.Tvstation;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX处理程序
 * @author 啊庭仔
 *
 */
public class TVstationHandler extends DefaultHandler {

	//存储所有电视台对象
	private List<Tvstation> list = new ArrayList<Tvstation>();

	public List<Tvstation> getList() {
		return list;
	}

	//保存一个电视台信息
	private Tvstation tvstation;
	
	
	/**
	 * 思路： 
	 * 	1）创建TVstation对象
	 *  2）把每个TVstation标签内容存入到TVstation对象
	 *  3）把TVstation对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到TVstation的开始标签创建TVstation对象
		if("TVstation".equals(qName)){
			tvstation = new Tvstation();
			
			//设置id值
			//System.out.println(attributes.getValue("cid"));
			tvstation.setTVid(Integer.valueOf(attributes.getValue("TVId")));
		}
	}
	

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//当前文本内容
		String content = new String(ch,start,length);
		
		if("TVname".equals(curTag)){
			tvstation.setTVname(content);
		}
		if("isfree".equals(curTag)){
			if("0".equals(content)){
				tvstation.setIsfree(true);
			}else{
				tvstation.setIsfree(false);
			}
		}
		if("introduction".equals(curTag)){
			tvstation.setIntroduction(content);
		}

	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到tvstation的结束标签放入List中
		if("TVstation".equals(qName)){
			list.add(tvstation);
		}
	}
	
}
