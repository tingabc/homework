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
        <span>电话服务列表：</span>
    </div>
    <div id="telephone" align="center" style="width: 1000px;height:250px;border:1px solid #F00;margin: auto;">
    		
    		<table border="1">
    		
    			<tr>
				    <th>套餐id</th>
				    <th>套餐名称</th>
				    <th>通话时间</th>
				    <th>手机流量</th>
				    <th>会员列表</th>
				</tr>
    			 <c:forEach items="${sessionScope.telephonelist}" var="tel">
    			 	<tr>
	    			 	<th>${tel.id}</th>
					    <th>${tel.name}</th>
					    <th>${tel.time}分钟/月</th>
					    <th>${tel.data}G/月</th>
					    <th>
					    <c:forEach items="${tel.members}" var="mem" varStatus="index">
					    	${mem.mName}
					    	<c:if test="${index.last==false}">
					    		,
					    	</c:if>
					    </c:forEach>
					    </th>
					</tr>
    			 </c:forEach>
    			
    		</table>
    </div>
   
    
  </body>
</html>
