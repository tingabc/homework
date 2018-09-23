package homework.tel.dao;

import homework.tel.entity.Order;

/**
 * 账单模块dao接口设计
 * @author 啊庭仔
 *
 */
public interface OrderDao extends BaseDao<Order>{

	/**
	 * 根据id查询账单
	 * @param id 账单id
	 * @return 账单
	 * @throws Exception
	 */
	public Order select(Integer id) throws Exception;
	
	/**
	 * 写入账单
	 * @param order 账单
	 * @throws Exception 
	 */
	public void insert(Order order) throws Exception;
}
