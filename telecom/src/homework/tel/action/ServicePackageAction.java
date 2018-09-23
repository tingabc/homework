package homework.tel.action;

import homework.tel.entity.Broadband;
import homework.tel.entity.Telephone;
import homework.tel.entity.Television;
import homework.tel.entity.Tvstation;
import homework.tel.service.BroadbandService;
import homework.tel.service.TelephoneService;
import homework.tel.service.TelevisionService;
import homework.tel.service.TvstationService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 服务action
 * @author 啊庭仔
 *
 */
@Controller
@RequestMapping("/service")
public class ServicePackageAction {

	@Resource
	private BroadbandService broadbandService;
	
	@Resource
	private TelephoneService telephoneService;
	
	@Resource
	private TelevisionService televisionService;
	
	@Resource
	private TvstationService tvstationService;
	
	@RequestMapping(value="/broadbandinit")
	public String Broadinit(HttpServletRequest request,HttpSession session){
		List<Broadband> broadbandlist = null ;
		try {
			broadbandlist = broadbandService.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(broadbandlist !=null){
			//存到session
			session.setAttribute("broadbandlist", broadbandlist);
			return "forward:/WEB-INF/main/broadband.jsp";
		}
		return "forward:/error.jsp";
	}

	@RequestMapping(value="/telephoneinit")
	public String Telephoneinit(HttpServletRequest request,HttpSession session){
		List<Telephone> telephonelist = null ;
		try {
			telephonelist = telephoneService.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(telephonelist !=null){
			//存到session
			session.setAttribute("telephonelist", telephonelist);
			return "forward:/WEB-INF/main/telephone.jsp";
		}
		return "forward:/error.jsp";
	}
	
	@RequestMapping(value="/televisioninit")
	public String Televisioninit(HttpServletRequest request,HttpSession session){
		//电视套餐的查询与存储
		List<Television> televisionlist = null ;
		try {
			televisionlist = televisionService.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(televisionlist !=null){
			//存到session
			session.setAttribute("televisionlist", televisionlist);
		}
		//电视台的查询与存储
		List<Tvstation> tvstationlist = null ;
		try {
			tvstationlist = tvstationService.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(tvstationlist !=null){
			//存到session
			session.setAttribute("tvstationlist", tvstationlist);
		}
		return "forward:/WEB-INF/main/television.jsp";
	}
}
