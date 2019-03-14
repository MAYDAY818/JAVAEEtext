<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
	Object object = session.getAttribute("user");

	if(object == null) {
		out.print("未登录<a href='LoginPageServlet'>去登录</a><br>");
	}else {
		UserBean user = (UserBean)session.getAttribute("user");
		out.print("登录人："+user.getName()+"<a href='LogoutServlet'>注销</a><br>");
	}
	Object onlineNumObj = application.getAttribute("onlineNum");
	if(onlineNumObj == null) {
		out.print("当前在线人数：0");
	}else {
		out.print("当前在线人数："+onlineNumObj);
	}
	Object vipNumObj = application.getAttribute("vipNum");
	if(vipNumObj == null) {
		out.print("当前在线会员数：0");
	}else {
		out.print("当前在线会员数："+vipNumObj);
	}
	%>
	
	JavaEE指南<a href="AddShoppingCartServlet?bookName=JavaEE指南">加入购物车</a><br> 
	JavaES指南<a href="AddShoppingCartServlet?bookName=JavaSE指南">加入购物车</a><br> 
	spring指南<a href="AddShoppingCartServlet?bookName=Spring指南">加入购物车</a><br> 
	<a href="ShowShoppingCartServlet">查看购物车</a><br> 
	</body> 
	</html>

	
</body>
</html>
</body>
</html>