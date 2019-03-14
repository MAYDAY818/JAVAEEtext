<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>LoginPageServlet</title>
</head>
<body>
	<%
	response.setContentType("text/html;charset=utf-8");
		if(session.getAttribute("user") != null) {
			response.sendRedirect("ProductListServlet");
		}else {
			if(request.getAttribute("msg") != null) {
				String msg = (String)request.getAttribute("msg");
				out.print("<font color='red'>"+msg+"</font>");
			}
	%>
			<form action="LoginCheckServlet">
			用户名：<input type="text" name="userName"><br>
			密码：<input type="password" name="password"><br>
			<input type="checkbox" name="autoLogin">7天内自动登录<br>
			<input type="submit" value="登录">
			</form> 
			</body>
			</html>
	<%
		}
	
	%>
	
</body>
</html>