package homework.tel.utils;



import homework.tel.entity.Customer;
import homework.tel.entity.Order;
import homework.tel.entity.OrderDetail;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 封装写入xml的操作
 * @author 啊庭仔
 *
 */
public class Writexml {

	/**
	 * 写出用户
	 * @param customer 用户
	 */
	public static void writeCustomer(Customer customer) throws Exception{
		//读取xml文档
		SAXReader reader = new SAXReader();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		System.out.println(path);
		Document doc = 
				reader.read(new File(path+"customer.xml"));
		
		
		//读取根标签
		Element rootELem = doc.getRootElement();
		
		//如果没有根标签就创建
		if(rootELem==null){
			//添加根标签
			rootELem = doc.addElement("customerList");
		}
		
		//增加标签
		Element customerElem = rootELem.addElement("customer");
		//增加属性
		customerElem.addAttribute("cid", Integer.toString(customer.getcId()));
		customerElem.addAttribute("account", customer.getAccount());
		//增加标签，同时设置文本
		customerElem.addElement("password").setText(customer.getPassword());
		customerElem.addElement("name").setText(customer.getName());
		customerElem.addElement("phone").setText(customer.getPhone());
		customerElem.addElement("address").setText(customer.getAddress());
		
		//内容写出到xml文件
		//输出位置
		FileOutputStream out = new FileOutputStream(path+"customer.xml");
		//指定格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置编码
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		//写出内容
		writer.write(doc);
		//关闭资源
		writer.close();
	}
	
	/**
	 * 根据cid查询出用户并修改账单
	 * @throws Exception
	 */
	public static void modifyCustomer(Customer customer) throws Exception{
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		//1.查询到cid的用户
		Document doc = new SAXReader().read(new File(path+"customer.xml"));
		//1.1 找到所有的Customer标签
		Iterator<Element> it = doc.getRootElement().elementIterator("customer");
		System.out.println(it);
		while(it.hasNext()){
			Element cusElem = it.next();
			//1.2 查询cid为传入的cid的用户标签
			if(Integer.valueOf(cusElem.attributeValue("cid")).equals(customer.getcId())){
				System.out.println(it);
				String oId = "";
				List<Integer> oIds = customer.getOrdersId();
				if(oIds!=null || oIds.size() !=0 ){
					for(int i=0;i<oIds.size();i++){
						oId = oId+oIds.get(i)+",";
					}
					oId.substring(0, oId.length()-1);
				}
				cusElem.element("oIds").setText(oId);
				break;
			}
		}
	
		
		//3.1 输出位置
		FileOutputStream out = new FileOutputStream(path+"customer.xml");
		//3.2 指定格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置编码
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		//3.3 写出内容
		writer.write(doc);
		//3.4关闭资源
		writer.close();
	}
	
	/**
	 * 写出账单
	 * @param order 账单
	 */
	public static void writeOrder(Order order) throws Exception{
		//读取xml文档
		SAXReader reader = new SAXReader();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		Document doc = 
				reader.read(new File(path+"order.xml"));
		
		
		//读取根标签
		Element rootELem = doc.getRootElement();
		
		//如果没有根标签就创建
		if(rootELem==null){
			//添加根标签
			rootELem = doc.addElement("orderList");
		}
		
		//增加标签
		Element orderElem = rootELem.addElement("order");
		//增加属性
		orderElem.addAttribute("oid", Integer.toString(order.getoId()));
		//增加标签，同时设置文本
		orderElem.addElement("cid").setText(Integer.toString(order.getcId()));
		orderElem.addElement("oDate").setText(order.getoDate());
		List<Integer> odIds = order.getOdIds();
		String odId = "";
		if(odIds!=null || odIds.size() !=0 ){
			for(int i=0;i<odIds.size();i++){
				odId = odId+odIds.get(i)+",";
			}
			odId.substring(0, odId.length()-1);
		}
		orderElem.addElement("odId").setText(odId);
		orderElem.addElement("totalcost").setText(Integer.toString(order.getTotalcost()));
		
		//内容写出到xml文件
		//输出位置
		FileOutputStream out = new FileOutputStream(path+"order.xml");
		//指定格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置编码
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		//写出内容
		writer.write(doc);
		//关闭资源
		writer.close();
	}
	/**
	 * 写出账单明细
	 * @param orderDetail 账单明细
	 */
	public static void writeOrderDetail(OrderDetail orderDetail) throws Exception{
		//读取xml文档
		SAXReader reader = new SAXReader();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		Document doc = 
				reader.read(new File(path+"orderDetail.xml"));
		
		
		//读取根标签
		Element rootELem = doc.getRootElement();
		
		//如果没有根标签就创建
		if(rootELem==null){
			//添加根标签
			rootELem = doc.addElement("orderDetailList");
		}
		
		//增加标签
		Element orderDetailElem = rootELem.addElement("orderDetail");
		//增加属性
		orderDetailElem.addAttribute("odid", Integer.toString(orderDetail.getOdId()));
		orderDetailElem.addAttribute("oId", Integer.toString(orderDetail.getoId()));
		//增加标签，同时设置文本
		orderDetailElem.addElement("detailDate").setText(orderDetail.getDetailDate());
		
		orderDetailElem.addElement("typeId").setText(Integer.toString(orderDetail.getTypeId()));
		orderDetailElem.addElement("pId").setText(Integer.toString(orderDetail.getpId()));
		orderDetailElem.addElement("cost").setText(Integer.toString(orderDetail.getCost()));
		
		//内容写出到xml文件
		//输出位置
		FileOutputStream out = new FileOutputStream(path+"orderDetail.xml");
		//指定格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置编码
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		//写出内容
		writer.write(doc);
		//关闭资源
		writer.close();
	}
}
