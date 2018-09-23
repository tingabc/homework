package homework.tel.utils;




import homework.tel.entity.Broadband;

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
public class BroadbandHandler extends DefaultHandler {

	//存储所有宽频对象
	private List<Broadband> list = new ArrayList<Broadband>();

	public List<Broadband> getList() {
		return list;
	}

	//保存一个宽频信息
	private Broadband broadband;
	/**
	 * 思路： 
	 * 	1）创建broadband对象
	 *  2）把每个broadband标签内容存入到broadband对象
	 *  3）把broadband对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到broadband的开始标签创建Broadband对象
		if("broadband".equals(qName)){
			broadband = new Broadband();
			
			//设置id值
			//System.out.println(attributes.getValue("cid"));
			broadband.setId(Integer.valueOf(attributes.getValue("id")));
		}
	}
	

	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//当前文本内容
		String content = new String(ch,start,length);
		
		if("name".equals(curTag)){
			broadband.setName(content);
		}
		
		if("speed".equals(curTag)){
			broadband.setSpeed(content);
		}
		
		if("cost".equals(curTag)){
			broadband.setCost(Integer.valueOf(content));
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到broadband的结束标签放入List中
		if("broadband".equals(qName)){
			list.add(broadband);
		}
	}
	
}
