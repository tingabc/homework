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
  <script type="text/javascript" src="../../js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
   	<div align="center">
        <span>宽频服务列表：</span>
    </div>
    <div id="broadband" align="center" style="width: 1000px;height:250px;border:1px solid #F00;margin: auto;">
    		
    		<table border="1">
    		
    			<tr>
				    <th>套餐id</th>
				    <th>套餐名称</th>
				    <th>上网速度</th>
				    <th>费用</th>
				</tr>
    			 <c:forEach items="${sessionScope.broadbandlist}" var="bro">
    			 	<tr>
	    			 	<th>${bro.id}</th>
					    <th>${bro.name}</th>
					    <th>${bro.speed}</th>
					    <th>${bro.cost}元/月</th>
					</tr>
    			 </c:forEach>
    			
    		</table>
    </div>
   
    
  </body>
</html>
