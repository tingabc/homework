package homework.tel.dao.impl;




import homework.tel.entity.Television;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX处理程序
 * @author 啊庭仔
 *
 */
public class SingleTelevisionHandler extends DefaultHandler {

	//用于查询的id
	private Integer id;

	//保存一个电视台信息
	private Television television;
	
	private boolean flag;
	
	public Television getTelevision() {
		return television;
	}
	
	public SingleTelevisionHandler(Integer id) {
		this.id=id;
	}
	
	/**
	 * 思路： 
	 * 	1）创建television对象用于储存查询结果
	 *  2）把需要查询的id以构造方法的形式传入
	 *  3）把得到的television对象保存
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到television的开始标签创建television对象
		if("television".equals(qName)){
			if(Integer.valueOf(attributes.getValue("id")).equals(id)){
				television = new Television();
				flag=true;
				//设置id值
				//System.out.println(attributes.getValue("cid"));
				television.setId(Integer.valueOf(attributes.getValue("id")));
			}
		}
	}
	

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(flag==true){
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

	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到television的结束标签放入List中
		if("television".equals(qName)){
			flag=false;
		}
	}
	
}
