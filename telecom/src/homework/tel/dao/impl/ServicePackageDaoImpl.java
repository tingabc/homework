package homework.tel.dao.impl;

import java.util.List;

import homework.tel.dao.ServicePackageDao;
import homework.tel.entity.ServicePackage;
import homework.tel.utils.Readxml;

import org.springframework.stereotype.Component;

@Component("servicePackageDao")
public class ServicePackageDaoImpl implements ServicePackageDao{

	@Override
	public List<ServicePackage> selectAll() throws Exception {
		return Readxml.readAllServicePackage();
	}

	//暂时没有实现
	@Override
	public <T> T find(Integer id) throws Exception {
		return null;
	}

	
	
	

}
