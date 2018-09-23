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
  
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  <script type="text/javascript">
  		$(function(){
  			//alert("喵喵");
  			$(".10").click(function(){
  				//alert("喵喵");
  				var oId = $(this).children().first().text();
  				//alert(oId);
  				var oDate = $(this).children().eq(1).text();
  				//alert(oDate);
				//参数一：url表示请求的路径
				var url = "${pageContext.request.contextPath}/customer/checkOrderDetail.action?orderId="+oId+"&date="+oDate;
				//alert(url);
  				window.location.href=url;
  			});
  		})
  </script>
  </head>
  
  <body>
   	<div align="center">
        <span>账单列表：</span>
    </div>
    <div id="order" align="center" style="width: 1000px;height:250px;border:1px solid #F00;margin: auto;">
    		
    		<table border="1">
    		
    			<tr>
				    <th>账单号</th>
				    <th>账单时间</th>
				    <th>总价</th>
				</tr>
    			 <c:forEach items="${sessionScope.orderlist}" var="ord">
	    			 	<tr id="10" class="10" onclick="${pageContext.request.contextPath}/customer/checkOrderDetail.action?orderId=${ord.oId}&date=${ord.oDate}">
		    			 	<th>${ord.oId}</th>
						    <th>${ord.oDate}</th>
						    <th>${ord.totalcost}元</th>
						</tr>
    			 </c:forEach>
    			
    		</table>
    		<br>
    		点击当前行可以查看对应详细账单
    </div>
   
    
  </body>
</html>
