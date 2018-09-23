package homework.tel.dao.impl;




import homework.tel.entity.OrderDetail;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX处理程序,根据账单id查询所有账单明细
 * @author 啊庭仔
 *
 */
public class OrderDetailListHandler extends DefaultHandler {
	
	//存储所有账单明细对象
	private List<OrderDetail> list = new ArrayList<OrderDetail>();

	public List<OrderDetail> getList() {
		return list;
	}
	
	//保存一个用于查找的账单id
	private Integer id;
	//编写构造器
	public OrderDetailListHandler(Integer id){
		this.id=id;
	}

	//设置一个判断旗帜
	private boolean flag=false;
	//保存一个账单明细信息
	private OrderDetail orderDetail;
	/**
	 * 思路： 
	 * 	1）创建OrderDetail对象
	 *  2）把每个OrderDetail标签内容存入到OrderDetail对象
	 *  3）把OrderDetail对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到orderDetail的开始标签创建OrderDetail对象
		if("orderDetail".equals(qName)){
			if(Integer.valueOf(attributes.getValue("oId")).equals(id)){
				flag=true;
				orderDetail = new OrderDetail();
				
				//设置id值
				//System.out.println(attributes.getValue("cid"));
				orderDetail.setOdId(Integer.valueOf(attributes.getValue("odid")));
				orderDetail.setoId(Integer.valueOf(attributes.getValue("oId")));
			}
		}
	}
	

	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(flag==true){
			//当前文本内容
			String content = new String(ch,start,length);
			
			if("detailDate".equals(curTag)){
				orderDetail.setDetailDate(content);
			}
			
			if("typeId".equals(curTag)){
				orderDetail.setTypeId(Integer.valueOf(content));
			}
			
			if("pId".equals(curTag)){
				orderDetail.setpId(Integer.valueOf(content));
			}
			
			if("cost".equals(curTag)){
				orderDetail.setCost(Integer.valueOf(content));
			}
			
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到orderDetail的结束标签放入List中
		if("orderDetail".equals(qName)){
			if(flag==true){
				list.add(orderDetail);
			}
			flag=false;
		}
	}
	
}
