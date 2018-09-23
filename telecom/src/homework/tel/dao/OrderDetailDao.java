package homework.tel.dao;

import homework.tel.entity.OrderDetail;

import java.util.List;

/**
 * 账单明细模块dao接口设计
 * @author 啊庭仔
 *
 */
public interface OrderDetailDao extends BaseDao<OrderDetail>{

	/**
	 * 根据账单id查询账单明细
	 * @param id 账单id
	 * @return 账单明细
	 * @throws Exception
	 */
	public List<OrderDetail> select(Integer id) throws Exception;
	
	/**
	 * 写入账单明细
	 * @param orderDetail 账单明细
	 * @throws Exception
	 */
	public void insert(OrderDetail orderDetail) throws Exception;
}
