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
   	<div class="login" id="unLoginShow" align="center">
        <span>电话服务列表：</span>
    </div>
    <div id="telephone" align="center" style="width: 1000px;height:250px;border:1px solid #F00;margin: auto;">
    		
    		<table border="1">
    		
    			<tr>
				    <th>套餐id</th>
				    <th>电视套餐名称</th>
				    <th>费用</th>
				    <th>简介</th>
				</tr>
    			 <c:forEach items="${sessionScope.televisionlist}" var="tele">
    			 	<tr>
	    			 	<th>${tele.id}</th>
					    <th>${tele.name}</th>
					    <th>${tele.cost}元/月</th>
					    <th>${tele.introduction}</th>
					</tr>
    			 </c:forEach>
    			
    		</table>
    		
    		
    </div>
    
     <div id="tvstation" align="center" style="width: 1000px;height:250px;border:1px solid #F00;margin: auto;">
     		电视台列表：<br>
     		<table border="1">
    		
    			<tr>
				    <th>电视台编号</th>
				    <th>电视台名字</th>
				    <th>是否收费</th>
				    <th>简介</th>
				</tr>
    			 <c:forEach items="${sessionScope.tvstationlist}" var="tv">
    			 	<tr>
	    			 	<th>${tv.TVid}</th>
					    <th>${tv.TVname}</th>
					    <th>
					    	<c:choose>
						    	<c:when test="${tv.isfree}">
						    			免费
						    	</c:when>
						    	<c:otherwise>
						    			收费
						    	</c:otherwise>
					    	
					    	</c:choose>
					    	
					    
					    </th>
					    <th>${tv.introduction}</th>
					</tr>
    			 </c:forEach>
    			
    		</table>
     </div>
   
    
  </body>
</html>
