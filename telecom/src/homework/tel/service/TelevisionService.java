package homework.tel.service;

import homework.tel.entity.Television;

/**
 * 电视套餐模块Service接口设计
 * @author 啊庭仔
 *
 */
public interface TelevisionService extends BaseService<Television>{

	/**
	 * 根据id查询记录
	 * @return 单个电视套餐记录
	 * @throws Exception
	 */
	public Television find(Integer id) throws Exception;
}
