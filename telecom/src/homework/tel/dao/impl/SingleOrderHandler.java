package homework.tel.dao.impl;




import homework.tel.entity.Order;

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
public class SingleOrderHandler extends DefaultHandler {

	

	//保存一个账单信息
	private Order order;
	
	
	private boolean flag=false;
	
	private Integer id;
	
	public SingleOrderHandler(Integer id){
		this.id=id;
	}
	
	
	public Order getOrder() {
		return order;
	}


	/**
	 * 思路： 
	 * 	1）创建Order对象
	 *  2）把每个Order标签内容存入到Order对象
	 *  3）把Order对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到order的开始标签创建Order对象
		if("order".equals(qName)){
			if(Integer.valueOf(attributes.getValue("oid")).equals(id)){
				flag=true;
				order = new Order();
				
				//设置id值
				//System.out.println(attributes.getValue("cid"));
				order.setoId(Integer.valueOf(attributes.getValue("oid")));
			}
			
		}
	}
	

	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(flag==true){
			//当前文本内容
			String content = new String(ch,start,length);
			
			if("cid".equals(curTag)){
				order.setcId(Integer.valueOf(content));
			}
			
			if("oDate".equals(curTag)){
				order.setoDate(content);
			}
			
			if("odId".equals(curTag)){
				if (content != null || !"".equals(content.trim())){
					String[] odIds = content.split(",");
					List<Integer> odIdList = new ArrayList<Integer>();
					for(int i = 0;i<odIds.length;i++){
						odIdList.add(Integer.valueOf(odIds[i]));
					}
					order.setOdIds(odIdList);
				}
			}
			
			if("totalcost".equals(curTag)){
				order.setTotalcost(Integer.valueOf(content));
			}
			
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到order的结束标签放入List中
		if("order".equals(qName)){
			flag=false;
		}
	}
	
}
