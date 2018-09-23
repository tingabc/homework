package homework.tel.dao;

import homework.tel.entity.Broadband;

import java.util.List;

public interface BaseDao<T> {

	//查询所有
	public List<T> selectAll() throws Exception;
	
	//根据id查询单个记录
	public <T>T find(Integer id) throws Exception;
}
