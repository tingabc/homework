package homework.tel.dao.impl;




import homework.tel.entity.Broadband;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX处理程序
 * @author 啊庭仔
 *
 */
public class SingleBroadbandHandler extends DefaultHandler {

	

	//用于查询的id
	private Integer id;
	//保存一个宽频信息
	private Broadband broadband;
	
	private boolean flag;
	
	public Broadband getBroadband() {
		return broadband;
	}

	public SingleBroadbandHandler(Integer id){
		this.id=id;
	}


	

	/**
	 * 思路： 
	 * 	1）创建broadband对象用于储存查询结果
	 *  2）把需要查询的id以构造方法的形式传入
	 *  3）把得到的broadband对象保存
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到broadband的开始标签创建Broadband对象
		if("broadband".equals(qName)){
			if(Integer.valueOf(attributes.getValue("id")).equals(id)){
				broadband = new Broadband();
				flag=true;
				//设置id值
				//System.out.println(attributes.getValue("cid"));
				broadband.setId(Integer.valueOf(attributes.getValue("id")));
				
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
				broadband.setName(content);
			}
			
			if("speed".equals(curTag)){
				broadband.setSpeed(content);
			}
			
			if("cost".equals(curTag)){
				broadband.setCost(Integer.valueOf(content));
			}
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//flag设成false
		if("broadband".equals(qName)){
			flag=false;
		}
	}
	
}
