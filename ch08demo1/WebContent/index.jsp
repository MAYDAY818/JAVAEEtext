<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String url = "head.jsp";%>
<div><%@include file="head.jsp" %></div>
<div>main</div>
<div>
<%
	request.setAttribute("userName2","lisi");
	session.setAttribute("userName3","wangwu");
	String foot = "foot.jsp";
%>
<jsp:include page="foot.jsp?userName=aaaaaaa">
	<jsp:param value="param1" name="param1"/>
	<jsp:param value="zhangsan" name="userName"/>
</jsp:include>
</div>

</body>
</html>