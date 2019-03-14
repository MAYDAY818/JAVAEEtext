<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>第一个jsp</h1>
<%
	String name = request.getParameter("userName");
	if (name!=null)
		out.print("你好,"+name);
	else
		out.print("你好,无名氏");
%>

<%
	for(int i=0;i<10;i++)
%>
		你好<%=name %>
<% 
	
%>
</body>
</html>