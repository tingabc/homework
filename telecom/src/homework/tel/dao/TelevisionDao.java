package homework.tel.dao;

import homework.tel.entity.Television;

/**
 *  套餐模块dao接口设计
 * @author 啊庭仔
 *
 */
public interface TelevisionDao extends BaseDao<Television>{

	/**
	 * 根据id查询记录
	 * @return 单个电视套餐记录
	 * @throws Exception
	 */
	public Television find(Integer id) throws Exception;
}
