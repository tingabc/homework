<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>


  <script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
  <body>
    
    <div style="width: 300px;height: 300px;margin: 0 auto;position: relative;border: 4px red solid;margin-top: 15%;">
    	<div style="width: 250px;height: 200px;margin: 0 auto;position: relative;border: 4px red solid;margin-top: 15%;">
	    	<form action="${pageContext.request.contextPath}/customer/register.action" method="post" name="form" onsubmit="checkpost()">
	    		账号：<input type="text" name="account" size="20" maxlength="5"></input><br>
	    		密码：<input type="password" name="password"><br>
	    		姓名：<input type="text" name="name"><br>
	    		电话：<input type="text" name="phone"><br>
	    		地址：<input type="text" name="address"><br>
	    		<br><br>
	    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交">&nbsp;
	    		<input type="button" onclick="history.go(-1)" value="返回">
	    	</form>
    	</div>
    </div>
    <script type="text/javascript">
    	/* function checkpost(){
			if(document.forms[5].name.value==""&&document.forms[5].pw.value==""){
			
				alert("请输入账号或密码！")
				window.location="https://www.baidu.com/";
			}else{
				return false;
		} */
		
    </script>
  </body>
</html>
