package homework.tel.service.impl;

import java.util.List;

import homework.tel.entity.OrderDetail;
import homework.tel.service.OrderDetailService;

import org.springframework.stereotype.Service;

@Service("orderDetailService")
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService{

	@Override
	public List<OrderDetail> select(Integer id) throws Exception {
		return orderDetailDao.select(id);
	}

	@Override
	public void insert(OrderDetail orderDetail) throws Exception {
		orderDetailDao.insert(orderDetail);
	}

	

}
