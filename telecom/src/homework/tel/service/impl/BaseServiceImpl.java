package homework.tel.service.impl;

import homework.tel.dao.BaseDao;
import homework.tel.dao.BroadbandDao;
import homework.tel.dao.CustomerDao;
import homework.tel.dao.OrderDao;
import homework.tel.dao.OrderDetailDao;
import homework.tel.dao.ServicePackageDao;
import homework.tel.dao.TvstationDao;
import homework.tel.dao.TelephoneDao;
import homework.tel.dao.TelevisionDao;
import homework.tel.service.BaseService;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl<T> implements BaseService<T>{

	protected  BaseDao<T> baseDao;
	
	@Autowired
	protected BroadbandDao broadbandDao;
	
	@Autowired
	protected CustomerDao customerDao;
	
	@Autowired
	protected OrderDao orderDao;
	
	@Autowired
	protected OrderDetailDao orderDetailDao;
	
	@Autowired
	protected ServicePackageDao servicePackageDao;
	
	@Autowired
	protected TelephoneDao telephoneDao;
	
	@Autowired
	protected TelevisionDao televisionDao;
	
	@Autowired
	protected TvstationDao tvstationDao;
	
	
	@Override
	public List<T> selectAll() throws Exception {
		return baseDao.selectAll();
	}
	
	@PostConstruct//在构造方法后，初化前执行
	private void initBaseMapper() throws Exception{
		//this关键字指对象本身，这里指的是调用此方法的实现类（子类）
		
		ParameterizedType type =(ParameterizedType) this.getClass().getGenericSuperclass();
		//获取第一个参数的class
		Class clazz = (Class)type.getActualTypeArguments()[0];
		//转化为属性名（相关的Mapper子类的引用名）Supplier  supplierMapper
		String localField = clazz.getSimpleName().substring(0,1).toLowerCase()+clazz.getSimpleName().substring(1)+"Dao";
		//getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
		Field field=this.getClass().getSuperclass().getDeclaredField(localField);
		Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
		
		//field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseMapper所指向的对象为其子类型SupplierMapper对象，子类型对象已被spring实例化于容器中		
		baseField.set(this, field.get(this));		
		System.out.println("========baseField对应的对象:"+baseDao);

	}

	@Override
	public <T> T find(Integer id) throws Exception {
		return baseDao.find(id);
	}	

}
