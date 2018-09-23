package homework.tel.dao;

import homework.tel.entity.Telephone;

/**
 *  套餐模块dao接口设计
 * @author 啊庭仔
 *
 */
public interface TelephoneDao extends BaseDao<Telephone>{

	/**
	 * 根据id查询记录
	 * @return 单个电话套餐记录
	 * @throws Exception
	 */
	public Telephone find(Integer id) throws Exception;
}
