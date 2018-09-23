package homework.tel.dao;

import homework.tel.entity.Customer;

/**
 *  用户模块dao接口设计
 * @author 啊庭仔
 *
 */
public interface CustomerDao extends BaseDao<Customer>{

	/**
	 * 主键查询单个记录
	 * @param id 用户编号
	 * @return 用户信息
	 * @throws Exception 
	 */
	public Customer select(Integer id) throws Exception;
	
	/**
	 * 根据账号查询单个记录
	 * @param account 账号
	 * @return 用户信息
	 * @throws Exception 
	 */
	public Customer select(String account) throws Exception;
	
	/**
	 * 写入数据
	 * @param customer 用户
	 * @throws Exception 
	 */
	public void insert(Customer customer) throws Exception;
	
	/**
	 * 根据用户id修改账单列表
	 * @param customer 封装了用户id的用户
	 * @throws Exception
	 */
	public void modify(Customer customer) throws Exception;
	
}
