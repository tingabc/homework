package homework.tel.utils;




import homework.tel.entity.Customer;

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
public class CustomerHandler extends DefaultHandler {

	//存储所有客户对象
	private List<Customer> list = new ArrayList<Customer>();

	public List<Customer> getList() {
		return list;
	}

	//保存一个客户信息
	private Customer customer;
	/**
	 * 思路： 
	 * 	1）创建Customer对象
	 *  2）把每个customer标签内容存入到Customer对象
	 *  3）把Customer对象放入List中
	 */
	//用于临时存储当前读到的标签名
	private String curTag;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		curTag = qName;
		//读取到contact的开始标签创建Contact对象
		if("customer".equals(qName)){
			customer = new Customer();
			
			//设置id值
			//System.out.println(attributes.getValue("cid"));
			customer.setcId(Integer.valueOf(attributes.getValue("cid")));
			customer.setAccount(attributes.getValue("account"));
		}
	}
	

	
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//当前文本内容
		String content = new String(ch,start,length);
		if("password".equals(curTag)){
			customer.setPassword(content);
		}
		
		if("name".equals(curTag)){
			customer.setName(content);
		}
		
		if("phone".equals(curTag)){
			customer.setPhone(content);
		}
		
		if("address".equals(curTag)){
			customer.setAddress(content);
		}
		
		if("oIds".equals(curTag)){
			if (content != null || !"".equals(content.trim())){
				String[] Ids = content.split(",");
				List<Integer> ordersId = new ArrayList<Integer>();
				for(int i = 0;i<Ids.length;i++){
					ordersId.add(Integer.valueOf(Ids[i]));
				}
				customer.setOrdersId(ordersId);
			}
			
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到contact的结束标签放入List中
		if("customer".equals(qName)){
			list.add(customer);
		}
	}
	
}
