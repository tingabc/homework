package homework.tel.test;

import homework.tel.entity.Customer;
import homework.tel.utils.Writexml;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.junit.Test;

public class TestWritexml {

	/*//测试写入用户
	@Test
	public void TestWriteCustomer() throws Exception{
		Customer customer = new Customer();
		customer.setcId(3);
		customer.setAccount("c");
		customer.setPassword("root");
		customer.setName("李四");
		customer.setPhone("12345678912");
		customer.setAddress("广东省广州市黄埔区");
		Writexml.writeCustomer(customer);
	}*/
	
	//测试写入用户账单
	@Test
	public void TestWriteCustomerOrder() throws Exception{
		Customer customer = new Customer();
		customer.setcId(2);
		customer.setAccount("c");
		customer.setPassword("root");
		customer.setName("李四");
		customer.setPhone("12345678912");
		customer.setAddress("广东省广州市黄埔区");
		List<Integer> ordersId= new ArrayList<Integer>();
		ordersId.add(1);
		ordersId.add(3);
		
		customer.setOrdersId(ordersId);
		Writexml.modifyCustomer(customer);
	}
	/*
	//测试写入账单
	@Test
	public void TestWriteOrder() throws Exception{
		Order order = new Order();
		order.setoId(006);
		order.setcId(002);
		order.setoDate("2018.07");
		List<Integer> ods = new ArrayList<Integer>();
		ods.add(002);
		order.setOdIds(ods);
		order.setTotalcost(2080);
		Writexml.writeOrder(order);
	}*/
	
	//测试写入账单明细
	/*@Test
	public void TestWriteOrderDetail() throws Exception{
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOdId(10);
		orderDetail.setoId(3);
		// 获得当前时间
		Date date = new Date();
		// 获得SimpleDateFormat类
		SimpleDateFormat detailDate = new SimpleDateFormat("yyyy.MM.dd");
		//打印当前时间
		System.out.println("当前时间:"+detailDate.format(date));
		orderDetail.setDetailDate(detailDate.format(date));
		
		orderDetail.setTypeId(2);
		orderDetail.setpId(2);
		orderDetail.setCost(3000);
		Writexml.writeOrderDetail(orderDetail);
	}*/
}
