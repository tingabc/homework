package homework.tel.dao.impl;

import homework.tel.dao.OrderDetailDao;
import homework.tel.entity.OrderDetail;
import homework.tel.utils.Readxml;
import homework.tel.utils.Writexml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;

@Component("orderDetailDao")
public class OrderDetailDaoImpl implements OrderDetailDao{

	@Override
	public List<OrderDetail> selectAll() throws Exception {
		return Readxml.readAllOrderDetail();
	}

	@Override
	public List<OrderDetail> select(Integer id) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		OrderDetailListHandler handler = new OrderDetailListHandler(id);
		String path = Readxml.class.getClassLoader().getResource("").toURI().getPath();
		parser.parse(new File(path+"orderDetail.xml"), handler);
		List<OrderDetail> list = handler.getList();
		return list;
	}

	@Override
	public void insert(OrderDetail orderDetail) throws Exception {
		Writexml.writeOrderDetail(orderDetail);
	}

	//暂时没有实现
	@Override
	public <T> T find(Integer id) throws Exception {
		return null;
	}


	
	

}
