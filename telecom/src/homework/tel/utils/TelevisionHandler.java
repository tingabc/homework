package homework.tel.utils;




import homework.tel.entity.Television;

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
public class TelevisionHandler extends DefaultHandler {

	//存储所有电视台对象
	private List<Television> list = new ArrayList<Television>();

	public List<Television> getList() {
		return list;
	}

	//保存一个电视台信息
	private Television television;
	
	
	/**
	 * 思路： 
	 * 	1）创建Television对象
	 *  2）把每个Television标签内容存入到Television对象
	 *  3）把Television对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到television的开始标签创建television对象
		if("television".equals(qName)){
			television = new Television();
			
			//设置id值
			//System.out.println(attributes.getValue("cid"));
			television.setId(Integer.valueOf(attributes.getValue("id")));
		}
	}
	

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//当前文本内容
		String content = new String(ch,start,length);
		
		if("name".equals(curTag)){
			television.setName(content);
		}
		if("cost".equals(curTag)){
			television.setCost(Integer.valueOf(content));
		}
		if("introduction".equals(curTag)){
			television.setIntroduction(content);
		}

	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到television的结束标签放入List中
		if("television".equals(qName)){
			list.add(television);
		}
	}
	
}
