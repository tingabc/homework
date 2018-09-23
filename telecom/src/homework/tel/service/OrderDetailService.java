package homework.tel.service;

import java.util.List;

import homework.tel.entity.OrderDetail;

/**
 * 账单明细模块Service接口设计
 * @author 啊庭仔
 *
 */
public interface OrderDetailService extends BaseService<OrderDetail>{

	/**
	 * 根据账单id查询账单
	 * @param id 账单id
	 * @return 账单
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
