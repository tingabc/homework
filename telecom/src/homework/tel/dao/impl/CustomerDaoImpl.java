package homework.tel.dao.impl;

import homework.tel.dao.CustomerDao;
import homework.tel.entity.Customer;
import homework.tel.utils.Readxml;
import homework.tel.utils.Writexml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;

@Component("customerDao")
public class CustomerDaoImpl implements CustomerDao{

	@Override
	public List<Customer> selectAll() throws Exception {
		
		return Readxml.readAllCustomer();
	}

	@Override
	public Customer select(Integer id) throws Exception{
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		SingleCustomerHandler handler = new SingleCustomerHandler(id);
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"customer.xml"), handler);
		Customer result = handler.getResult();
		
		return result;
	}
	
	@Override
	public Customer select(String account) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		SingleCustomerHandler handler = new SingleCustomerHandler(account);
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"customer.xml"), handler);
		Customer result = handler.getResult();
		
		return result;
	}

	@Override
	public void insert(Customer customer) throws Exception {
		Writexml.writeCustomer(customer);
	}

	@Override
	public void modify(Customer customer) throws Exception {
		Writexml.modifyCustomer(customer);
	}

	//暂时没有实现
	@Override
	public <T> T find(Integer id) throws Exception {
		return null;
	}
	

}
