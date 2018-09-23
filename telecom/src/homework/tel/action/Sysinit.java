package homework.tel.action;

import homework.tel.service.SysInitService;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 加载系统数据
 * @author 啊庭仔
 *
 */
@Controller
@RequestMapping("/Sysinit")
public class Sysinit extends BaseAction {

	@Resource
	private SysInitService sysInitService;
	
	@RequestMapping(value="index")
	public String login(HttpServletRequest request,HttpSession session){
		
		return "forward:/WEB-INF/main/main.jsp";
	}
	
	
	
	//后边可以用来重新加载参数
	@RequestMapping(value = "/reload")
	@ResponseBody
	public void reloadSysParam(){
		//loadSysParam
		loadSysParam();
	}
	
	//系统启动时加载参数
	@PostConstruct
	public void initSysParam(){
		loadSysParam();
	}
	
	//用来加载系统参数
	private void loadSysParam() {

		Map<String, Object> sysParamMap = sysInitService.selectList();
		
		application.setAttribute("sysParam", sysParamMap);
		System.out.println(sysParamMap.get("ServicePackage"));
		
		System.out.println("=======================系统参数加载成功===========================");
	}
}
