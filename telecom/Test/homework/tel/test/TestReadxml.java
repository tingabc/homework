package homework.tel.test;

import homework.tel.dao.impl.BroadbandDaoImpl;
import homework.tel.dao.impl.CustomerDaoImpl;
import homework.tel.dao.impl.OrderDaoImpl;
import homework.tel.dao.impl.TelephoneDaoImpl;
import homework.tel.entity.Broadband;
import homework.tel.entity.Customer;
import homework.tel.entity.Member;
import homework.tel.entity.Order;
import homework.tel.entity.OrderDetail;
import homework.tel.entity.ServicePackage;
import homework.tel.entity.Telephone;
import homework.tel.entity.Tvstation;
import homework.tel.service.impl.BroadbandServiceImpl;
import homework.tel.utils.Readxml;

import java.util.List;

import org.junit.Test;

public class TestReadxml {

	public static void main(String[] args) throws Exception {
		/*Readxml read = new Readxml();
		read.readAllCustomer();*/
		List<Customer> readAllCustomer = Readxml.readAllCustomer();
		for (Customer customer : readAllCustomer) {
			System.out.println(customer);
		}
	}
	
	//测试broadband。xml的读取
	@Test
	public void TestReadbroadband() throws Exception{
		List<Broadband> readAllBroadband = Readxml.readAllBroadband();
		for (Broadband broadband : readAllBroadband) {
			System.out.println(broadband);
		}
	}
	
	//测试member。xml的读取
	@Test
	public void TestMember() throws Exception{
		List<Member> readAllMember = Readxml.readAllMember();
		for (Member member : readAllMember) {
			System.out.println(member);
		}
	}
	//测试order.xml的读取
	@Test
	public void Testorder() throws Exception{
		List<Order> readAllOrder = Readxml.readAllOrder();
		for (Order order : readAllOrder) {
			System.out.println(order);
		}
	}
	//测试orderDetail.xml的读取
	@Test
	public void TestorderDetail() throws Exception{
		List<OrderDetail> readAllOrderDetail = Readxml.readAllOrderDetail();
		for (OrderDetail orderDetail : readAllOrderDetail) {
			System.out.println(orderDetail);
		}
	}
	//测试ServicePackage.xml的读取
	@Test
	public void TestServicePackage() throws Exception{
		List<ServicePackage> readAllServicePackage = Readxml.readAllServicePackage();
		for (ServicePackage servicePackage : readAllServicePackage) {
			System.out.println(servicePackage);
		}
	}
	//测试Telephone.xml的读取
	@Test
	public void TestTelephone() throws Exception{
		List<Telephone> readAllTelephone = Readxml.readAllTelephone();
		for (Telephone telephone : readAllTelephone) {
			System.out.println(telephone);
		}
	}
	//测试TVstation.xml的读取
	@Test
	public void TestTVstation() throws Exception{
		List<Tvstation> readAllTVstation = Readxml.readAllTVstation();
		for (Tvstation tvstation : readAllTVstation) {
			System.out.println(tvstation);
		}
	}
	//测试customerdaoimpl.xml的id、account读取
	@Test
	public void TestSingleCustomer() throws Exception{
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customer = customerDaoImpl.select(1);
		System.out.println(customer);
		Customer customer2 = customerDaoImpl.select("a");
		System.out.println(customer2);
	}
	//测试orderdaoimpl.xml的id读取
	@Test
	public void Testorderdaoimpl() throws Exception{
		Integer id = 2;
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		Order order = orderDaoImpl.select(id);
		System.out.println(order);
		
	}
	//测试从broadbandservice中对broadband.xml的id读取
	/*@Test
	public void Testbroadbandimpl() throws Exception{
		Integer id = 2;
		BroadbandServiceImpl broadbandServiceImpl = new BroadbandServiceImpl();
		Broadband broadband = broadbandServiceImpl.find(id);
		System.out.println(broadband);
		
	}*/
	/*@Test
	public void Testbroadbandimpl() throws Exception{
		//Integer id = 2;
		BroadbandServiceImpl broadbandServiceImpl = new BroadbandServiceImpl();
		 List<Broadband> list = broadbandServiceImpl.selectAll();
		for(Broadband broadband:list){
			System.out.println(broadband);
			
		}
		
	}*/
	/*@Test
	public void Testbroadbandimpl() throws Exception{
		Integer id = 2;
		BroadbandDaoImpl broadbandDaoImpl = new BroadbandDaoImpl();
		Broadband broadband = broadbandDaoImpl.find(id);
		System.out.println(broadband);
		
	}*/
	//测试orderdaoimpl.xml的id读取
	@Test
	public void TestSingleTelephonedaoimpl() throws Exception{
		Integer id = 2;
		TelephoneDaoImpl telephoneDaoImpl = new TelephoneDaoImpl();
		Telephone telephone = telephoneDaoImpl.find(id);
		System.out.println(telephone);
		
	}
	
}
