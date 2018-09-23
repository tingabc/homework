package homework.tel.service;

import java.util.List;

public interface PackageService<T> {

	//查询所有
	public List<T> find() throws Exception;
}
