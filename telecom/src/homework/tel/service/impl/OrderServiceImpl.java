package homework.tel.service.impl;

import homework.tel.entity.Customer;
import homework.tel.entity.Order;
import homework.tel.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService{

	

	@Override
	public void insert(Order order) throws Exception {
		orderDao.insert(order);
	}

	@Override
	public List<Order> select(Customer customer) throws Exception {
		List<Order> orders = new ArrayList<Order>();
		List<Integer> ordersId = customer.getOrdersId();
		
		for(Integer id:ordersId){
			orders.add(orderDao.select(id));
		}
		return orders;
	}

}
