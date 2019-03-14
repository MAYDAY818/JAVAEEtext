<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String temp = "16";
	request.setAttribute("temp1",temp);
	session.setAttribute("temp2",temp);
	application.setAttribute("temp3",temp);
%>
<jsp:forward page="test.jsp">
	<jsp:param value="<%=temp %>" name="temp"/>
	<jsp:param value="" name="userName"/>
	<jsp:param value="Java" name="hobby"/>	
	<jsp:param value="Python" name="hobby"/>	
	<jsp:param value="C" name="hobby"/>	
</jsp:forward>
</body>
</html>