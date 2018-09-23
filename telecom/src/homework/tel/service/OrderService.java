package homework.tel.service;

import homework.tel.entity.Customer;
import homework.tel.entity.Order;

import java.util.List;

/**
 * 账单模块Service接口设计
 * @author 啊庭仔
 *
 */
public interface OrderService extends BaseService<Order>{

	/**
	 * 根据id查询账单
	 * @param id 账单id
	 * @return 账单
	 * @throws Exception
	 */
	public List<Order> select(Customer customer) throws Exception;
	
	/**
	 * 写入账单
	 * @param order 账单
	 * @throws Exception 
	 */
	public void insert(Order order) throws Exception;
}
