package homework.tel.service;

import homework.tel.entity.Customer;

/**
 *  用户模块dao接口设计
 * @author 啊庭仔
 *
 */
public interface CustomerService extends BaseService<Customer>{

	/**
	 * 登录
	 * @param id 用户编号
	 * @return 用户信息
	 * @throws Exception
	 */
	public Customer login(Integer id) throws Exception;
	
	/**
	 * 登录
	 * @param account 用户账号
	 * @return 用户信息
	 * @throws Exception
	 */
	public Customer login(String account) throws Exception;
	
	/**
	 * 注册
	 * @param customer 用户
	 * @throws Exception
	 */
	public void register(Customer customer) throws Exception;
	
	/**
	 * 根据用户id修改账单列表
	 * @param customer 封装了用户id的用户
	 * @throws Exception
	 */
	public void modify(Customer customer) throws Exception;
}
