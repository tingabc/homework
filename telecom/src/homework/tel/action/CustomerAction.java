package homework.tel.action;

import homework.tel.entity.Broadband;
import homework.tel.entity.Customer;
import homework.tel.entity.Order;
import homework.tel.entity.OrderDetail;
import homework.tel.entity.Service;
import homework.tel.entity.ServicePackage;
import homework.tel.service.BaseService;
import homework.tel.service.BroadbandService;
import homework.tel.service.CustomerService;
import homework.tel.service.OrderDetailService;
import homework.tel.service.OrderService;
import homework.tel.service.ServicePackageService;
import homework.tel.service.TelephoneService;
import homework.tel.service.TelevisionService;
import homework.tel.service.TvstationService;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 用户action
 * @author 啊庭仔
 *
 * @param <T>
 */
@Controller
@RequestMapping("/customer")
public class CustomerAction<T> {

	private BaseService<T> baseService;
	
	@Resource
	private CustomerService customerService;
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private OrderDetailService orderDetailService;
	
	@Resource
	private ServicePackageService servicePackageService;
	
	@Resource
	private BroadbandService broadbandService;
	
	@Resource
	private TelephoneService telephoneService;
	
	@Resource
	private TelevisionService televisionService;
	
	@Resource
	private TvstationService tvstationService;
	
	private String orderId;
	
	private String date;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	//登录
	@RequestMapping(value="/login")
	public String login(Customer customer,HttpServletRequest request,HttpSession session){
		Customer cus;
		try {
			cus = customerService.login(customer.getAccount());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		if(cus!=null){
			//存session
			session.setAttribute("customer", cus);
			return "forward:/WEB-INF/main/main.jsp";
		}else{
			request.setAttribute("msg", "用户名或密码错误！");
			return "forward:/Login.jsp";
		}
	}
	//注册
	@RequestMapping(value="/register")
	public String register(Customer customer,HttpServletRequest request,HttpSession session){
		try {
			customerService.register(customer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		return "forward:/Login.jsp";
	}
	//退出登录
	@RequestMapping(value="/signout")
	public String signout(HttpServletRequest request,HttpSession session){
		session.removeAttribute("customer");
		
		
		return "forward:/WEB-INF/main/main.jsp";
	}
	
	//查看账单
	@RequestMapping(value="/checkOrder")
	public String checkOrder(HttpServletRequest request,HttpSession session){
		Customer customer= (Customer) session.getAttribute("customer");
		List<Order> orderlist;
		try {
			orderlist = orderService.select(customer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		//存session
		session.setAttribute("orderlist", orderlist);
		return "forward:/WEB-INF/main/order.jsp";
		
	}
	
	//修改账单
	@RequestMapping(value="/modify")
	public String modify(Customer customer,HttpServletRequest request,HttpSession session){
		try {
			customerService.modify(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "forward:/WEB-INF/main/main.jsp";
	}
	
	//查看账单明细
	@RequestMapping(value="/checkOrderDetail")
	public String checkOrderDetail(String orderId,String date,HttpServletRequest request,HttpSession session){
		//查找账单明细的内容
		List<OrderDetail> orderDetaillist;
		try {
			orderDetaillist = orderDetailService.select(Integer.valueOf(orderId));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//查询所有套餐类型
		List<ServicePackage> servicelist = null;
		try {
			servicelist = servicePackageService.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//创建一个map来保存套餐类型
		Map<Integer,String> servicetypemap = new HashMap<Integer, String>();
		//创建一个map来保存套餐名(拓展的话可以保存许多套餐内容，但现在只保存名称)
		Map<Integer,String> servicemap = new HashMap<Integer, String>();
		if(servicelist!=null){
			//根据查到的账单明细中的套餐类型和编号查找套餐内容
			for(OrderDetail orderDetail:orderDetaillist){
				for(ServicePackage servicePackage:servicelist){
					if(orderDetail.getTypeId().equals(servicePackage.getTypeId())){
						//获得对应的类型名称
						String classname = servicePackage.getServiceName();
						//获得将要调用的service名(该类中对应service属性名)
						String  serviceName= classname+"Service";
						System.out.println(serviceName);
						//保存对应方法
						Field field;
						try {
							//getDeclaredField:可以使用于包括私有、默认、受保护、公共字段，但不包括继承的字段
							field =this.getClass().getDeclaredField(serviceName);
						} catch (SecurityException e) {
							e.printStackTrace();
							return "forward:/error.jsp";
						} catch (NoSuchFieldException e) {
							e.printStackTrace();
							return "forward:/error.jsp";
						}
						try {
							Field baseField = this.getClass().getDeclaredField("baseService");
							//field.get(this)获取当前this的field字段的值。（把得到的对象放入baseService中）	
							baseField.set(this, field.get(this));
							//首字母大写
							classname=classname.substring(0,1).toUpperCase().concat(classname.substring(1));
							//先获得相对路径
							String path = new Broadband().getClass().getName();
							System.out.println(path);
							//稍加拼接
							int index = path.indexOf("Broadband");
							classname = path.substring(0,index)+classname;
							System.out.println(classname);
							//得到该类的对象
							Class classObj = Class.forName(classname);
							//创建该类
							Service service = (Service)classObj.newInstance();
							System.out.println(service);
							//调取该类的find方法
							service = baseService.find(orderDetail.getpId());
							//得到对象的名字属性
							System.out.println(service);
							String name = service.getName();
							System.out.println(name);
							System.out.println(orderDetail.getTypeId());
							servicemap.put(orderDetail.getTypeId(),name);
							
							//保存套餐类型
							servicetypemap.put(orderDetail.getTypeId(), servicePackage.getServiceName());
							
						} catch (Exception e) {
							e.printStackTrace();
							return "forward:/error.jsp";
						}
						
					}
				}
			}
		}
		
		//把账单日期也保存到session中
		session.setAttribute("orderDate", date);
		//存session
		session.setAttribute("orderDetaillist", orderDetaillist);
		//保存对应套餐名
		session.setAttribute("servicemap", servicemap);
		//保存套餐类型
		session.setAttribute("servicetypemap", servicetypemap);
		return "forward:/WEB-INF/main/orderDetail.jsp";
		
	}
	
}
