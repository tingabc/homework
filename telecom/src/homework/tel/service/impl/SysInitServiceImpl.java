package homework.tel.service.impl;

import homework.tel.dao.ServicePackageDao;
import homework.tel.entity.ServicePackage;
import homework.tel.service.SysInitService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysParamService")
public class SysInitServiceImpl implements SysInitService {

	@Autowired
	private ServicePackageDao servicePackageDao;
	
	@Override
	public Map<String, Object> selectList() {
		
		//系统参数Map,用来存放所有字段的相关参数信息
		Map<String,Object> sysParamMap = new HashMap<String, Object>();
		
		
		//创建list存放套餐服务的列表
		List<ServicePackage> list;
		//执行查询并把列表存放在list中
		try {
			list = servicePackageDao.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//把list存放到sysParamMap中
		sysParamMap.put("ServicePackage", list);
		
		
		return sysParamMap;
	}
	
	

	


}
