package homework.tel.servlet;

import homework.tel.dao.ServicePackageDao;
import homework.tel.dao.impl.ServicePackageDaoImpl;
import homework.tel.entity.ServicePackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class SysInitServlet extends HttpServlet{

	
	private ServicePackageDao servicePackageDao = new ServicePackageDaoImpl();
	
	//系统开始时创建
	public void init() throws ServletException {
		//创建map保存数据
		Map<String,Object> sysParamMap =new HashMap<String,Object>();

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
		
		//把map保存到域中
		//this.getServletContext().setAttribute("sysParam", sysParamMap);
		
		System.out.println("-------------------系统参数加载成功---------------------");

	}
}
