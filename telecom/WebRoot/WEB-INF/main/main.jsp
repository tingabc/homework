<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎来到我的网站</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script></head>
  <script type="text/javascript">
  	$(function(){
	  		var str = "${sessionScope.customer.account}";
	  		if(str==null||str==""){
	  			$("#user").hide();
	  			$("#order").hide();
	  			$("#login").show();
	  			$("#register").show();
	  			$("#signout").hide(); 
	  		}else{
	  			$("#user").show();
	  			$("#order").show();
	  			$("#login").hide();
	  			$("#register").hide();
	  			$("#signout").show(); 
	  		}
  		
  		
  	})
  	
  	
  </script> 
  
  <body>
   	<div class="login" id="unLoginShow" align="center">
        <span>欢迎来到我的网站</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><a target='_top' id='login' href='${pageContext.request.contextPath}/Login.jsp'>登录</a>&nbsp;<a target='_top' id='register' href='${pageContext.request.contextPath}/Register.jsp'>注册</a>&nbsp;
        &nbsp;<a target='_top' id='signout' href='${pageContext.request.contextPath}/customer/signout.action'>退出</a>&nbsp;</span>
    </div>
    <div id="user" align="center" style="width: 1000px;height:250px;border:1px solid #F00;margin: auto;">
    		欢迎您 ：${sessionScope.customer.account}<br>
    		<table border="1">
    			 <tr>
				    <th>姓名</th>
				    <th>${sessionScope.customer.name}</th>
				  </tr>
				  <tr>
				    <td>电话</td>
				    <td>${sessionScope.customer.phone}</td>
				  </tr>
				  <tr>
				    <td>地址</td>
				    <td>${sessionScope.customer.address}</td>
				  </tr>
    		</table>
    </div>
    <div align="center" style="width: 1000px;height:200px;border:1px solid #F00;margin: auto;">
    <font size="3">请选择您想要了解的服务:</font><br/><br> 
    	<font size="5"><c:forEach items="${applicationScope.sysParam.ServicePackage}" var="ServicePackage">
					    <a target='_blank' id='${ServicePackage.typeId}' href='${pageContext.request.contextPath}/service/${ServicePackage.serviceName}init.action'>${ServicePackage.typeName}</a>&nbsp; 
		</c:forEach></font> 
    </div>
    <div id="order" align="center" style="width: 1000px;height:100px;border:1px solid #F00;margin: auto;">
    	<font size="5"><a target='_blank' id='order' href='${pageContext.request.contextPath}/customer/checkOrder.action'>账单查询</a>&nbsp;</font>
    </div>
    
  </body>
</html>
