package homework.tel.dao.impl;




import homework.tel.entity.Customer;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAX处理程序,根据id或account查询单个客户数据
 * @author 啊庭仔
 *
 */
public class SingleCustomerHandler extends DefaultHandler {


	//保存一个客户信息
	private Customer customer = new Customer();
	//保存一个查询出来的客户信息
	private Customer result;
	
	
	public Customer getResult() {
		return result;
	}

	private boolean flag;
	
	public SingleCustomerHandler(Integer id) {
		this.customer.setcId(id);
	}
	
	public SingleCustomerHandler(String account) {
		this.customer.setAccount(account);
	}
	
	/**
	 * 思路： 
	 * 	1）创建broadband对象用于储存查询结果
	 *  2）把需要查询的id或账号以构造方法的形式传入
	 *  3）把得到的broadband对象保存
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到contact的开始标签创建Contact对象
		if("customer".equals(qName)){
			if(Integer.valueOf(attributes.getValue("cid")).equals(customer.getcId())||attributes.getValue("account").equals(customer.getAccount())){
				result = new Customer();
				flag = true;
				//设置id值
				//System.out.println(attributes.getValue("cid"));
				result.setcId(Integer.valueOf(attributes.getValue("cid")));
				result.setAccount(attributes.getValue("account"));
				
			}
		}
	}
	

	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(flag==true){
			//当前文本内容
			String content = new String(ch,start,length);
			if("password".equals(curTag)){
				result.setPassword(content);
			}
			
			if("name".equals(curTag)){
				result.setName(content);
			}
			
			if("phone".equals(curTag)){
				result.setPhone(content);
			}
			
			if("address".equals(curTag)){
				result.setAddress(content);
			}
			
			if("oIds".equals(curTag)){
				if (content != null || !"".equals(content.trim())){
					String[] Ids = content.split(",");
					List<Integer> ordersId = new ArrayList<Integer>();
					for(int i = 0;i<Ids.length;i++){
						ordersId.add(Integer.valueOf(Ids[i]));
					}
					result.setOrdersId(ordersId);
				}
				
			}
			
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//把flag设成false
		if("customer".equals(qName)){
			if(result!=null){
				flag = false;
			}
		}
	}
	
}
