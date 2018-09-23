package homework.tel.service;

import java.util.List;

public interface BaseService<T> {

	//查询所有
	public List<T> selectAll() throws Exception;
	//根据id查询单个记录
	public <T>T find(Integer id) throws Exception;
}
