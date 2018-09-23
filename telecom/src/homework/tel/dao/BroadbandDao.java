package homework.tel.dao;

import homework.tel.entity.Broadband;

/**
 * 宽频模块dao接口设计
 * @author 啊庭仔
 *
 */
public interface BroadbandDao extends BaseDao<Broadband>{

	/**
	 * 根据id查询记录
	 * @return 单个宽频套餐记录
	 * @throws Exception
	 */
	public Broadband find(Integer id) throws Exception;
}
