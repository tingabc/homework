package homework.tel.utils;


import homework.tel.entity.Broadband;
import homework.tel.entity.Customer;
import homework.tel.entity.Member;
import homework.tel.entity.Order;
import homework.tel.entity.OrderDetail;
import homework.tel.entity.ServicePackage;
import homework.tel.entity.Telephone;
import homework.tel.entity.Television;
import homework.tel.entity.Tvstation;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 封装读取xml的操作
 * @author 啊庭仔
 *
 */
public class Readxml {

	
	/**
	 * 读取所有用户信息
	 * @return 用户信息列表
	 */
	public static List<Customer> readAllCustomer() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		CustomerHandler handler = new CustomerHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"customer.xml"), handler);
		List<Customer> list = handler.getList();
		/*
		for (Customer customer : list) {
			System.out.println(customer);
		}
		*/
		return list;
	}
	
	/**
	 * 读取所有宽频信息
	 * @return 宽频信息列表
	 */
	public static List<Broadband> readAllBroadband() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		BroadbandHandler handler = new BroadbandHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"broadband.xml"), handler);
		List<Broadband> list = handler.getList();
		/*
		for (Customer customer : list) {
			System.out.println(customer);
		}
		*/
		return list;
	}
	/**
	 * 读取所有会员信息
	 * @return 会员信息列表
	 */
	public static List<Member> readAllMember() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		MemberHandler handler = new MemberHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"member.xml"), handler);
		List<Member> list = handler.getList();
		/*
		for (Customer customer : list) {
			System.out.println(customer);
		}
		*/
		return list;
	}
	/**
	 * 读取所有账单信息
	 * @return 账单信息列表
	 */
	public static List<Order> readAllOrder() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		OrderHandler handler = new OrderHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"order.xml"), handler);
		List<Order> list = handler.getList();
		/*
		for (Customer customer : list) {
			System.out.println(customer);
		}
		*/
		return list;
	}
	/**
	 * 读取所有账单详细信息
	 * @return 账单详细信息列表
	 */
	public static List<OrderDetail> readAllOrderDetail() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		OrderDetailHandler handler = new OrderDetailHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"orderDetail.xml"), handler);
		List<OrderDetail> list = handler.getList();
		/*
		for (Customer customer : list) {
			System.out.println(customer);
		}
		*/
		return list;
	}
	/**
	 * 读取所有套餐信息
	 * @return 套餐信息列表
	 */
	public static List<ServicePackage> readAllServicePackage() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		ServicePackageHandler handler = new ServicePackageHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath(); 
		//System.out.println(path+"ServicePackage.xml");
		parser.parse(new File(path+"ServicePackage.xml"), handler);
		List<ServicePackage> list = handler.getList();
		/*
		for (Customer customer : list) {
			System.out.println(customer);
		}
		*/
		return list;
	}
	/**
	 * 读取所有电话套餐信息
	 * @return 套餐信息列表
	 */
	public static List<Telephone> readAllTelephone() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		TelephoneHandler handler = new TelephoneHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"telephone.xml"), handler);
		List<Telephone> list = handler.getList();
		
		return list;
	}
	/**
	 * 读取所有电视台信息
	 * @return 电视台信息列表
	 */
	public static List<Tvstation> readAllTVstation() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		TVstationHandler handler = new TVstationHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"TVstation.xml"), handler);
		List<Tvstation> list = handler.getList();
		
		return list;
	}
	/**
	 * 读取所有电视套餐
	 * @return 电视套餐信息列表
	 */
	public static List<Television> readAllTelevision() throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		TelevisionHandler handler = new TelevisionHandler();
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"television.xml"), handler);
		List<Television> list = handler.getList();
		
		return list;
	}
}
