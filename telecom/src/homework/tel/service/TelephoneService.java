package homework.tel.service;

import homework.tel.entity.Telephone;

/**
 * 电话套餐模块Service接口设计
 * @author 啊庭仔
 *
 */
public interface TelephoneService extends BaseService<Telephone>{

	/**
	 * 根据id查询记录
	 * @return 单个电话套餐记录
	 * @throws Exception
	 */
	public Telephone find(Integer id) throws Exception;
}
