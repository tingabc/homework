package homework.tel.Interceptor;

import homework.tel.entity.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String requestUri = request.getRequestURI();
		//System.out.println(requestUri);
		String contextPath = request.getContextPath();
		//System.out.println(contextPath);
		String url = requestUri.substring(contextPath.length());
		//System.out.println(url);
		if("/".equals(url)||requestUri.endsWith(".jsp")||requestUri.endsWith("login.action")||requestUri.endsWith("register.action")){
			return true;
		}else{
			Customer customer = (Customer) request.getSession().getAttribute("customer");
			if(customer==null){
				request.setAttribute("tip", "使用此功能请先登录");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
				return false;
			}else{
				return true;
			}
		}
		
	}
	
}
