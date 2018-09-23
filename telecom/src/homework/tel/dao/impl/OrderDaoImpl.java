package homework.tel.dao.impl;

import homework.tel.dao.OrderDao;
import homework.tel.entity.Order;
import homework.tel.utils.Readxml;
import homework.tel.utils.Writexml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;

@Component("orderDao")
public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Order> selectAll() throws Exception {
		return Readxml.readAllOrder();
	}

	@Override
	public Order select(Integer id) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		SingleOrderHandler handler = new SingleOrderHandler(id);
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"order.xml"), handler);
		Order order = handler.getOrder();
		return order;
	}

	@Override
	public void insert(Order order) throws Exception {
		Writexml.writeOrder(order);
	}

	//暂时没有实现
	@Override
	public <T> T find(Integer id) throws Exception {
		return null;
	}


	
	

}
