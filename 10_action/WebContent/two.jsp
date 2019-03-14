<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
include action example
<br>
this is a1=<%=request.getParameter("a1") %><br>
this is a2=<%=request.getParameter("a2") %><br>
<%
	out.println("hello from two.jsp");
%>
</body>
</html>