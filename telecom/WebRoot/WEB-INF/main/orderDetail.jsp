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
        <span>${sessionScope.orderDate}月账单列表：</span>
    </div>
    <div id="orderDetail" align="center" style="width: 1000px;height:250px;border:1px solid #F00;margin: auto;">
    		
    		<table border="1">
    		
    			<tr>
				    <th>账单号</th>
				    <th>账单时间</th>
				    <th>套餐名称</th>
				    <th>费用</th>
				</tr>
    			 <c:forEach items="${sessionScope.orderDetaillist}" var="od">
	    			 	<tr>
		    			 	<th>${od.odId}</th>
						    <th>${od.detailDate}</th>
						    
						   
						    <th>
						    	
						    	<c:forEach items="${sessionScope.servicemap}" var="map">
						    		<c:if test="${map.key==od.typeId }">
						    				<c:forEach items="${sessionScope.servicetypemap}" var="stmap">
						    					<c:if test="${stmap.key==od.typeId}">
							    					<a target='_blank' href='${pageContext.request.contextPath}/service/${stmap.value}init.action'>
							    						${map.value}
							    					</a>
						    					
						    					</c:if>
						    				</c:forEach>
						    		</c:if>
						    	</c:forEach> 
						    </th>
						    <th>${od.cost}</th>
						</tr>
    			 </c:forEach>
    			
    		</table>
    		<br>
    		<input type="button" onclick="history.go(-1)" value="返回">
    </div>
   
    
  </body>
</html>
