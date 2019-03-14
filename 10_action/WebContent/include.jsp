<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file = "static.html" %>
<a href = "two.jsp">goto two.....</a><br>
this is example show include works
<jsp:include page = "/two.jsp" flush="true">
	<jsp:param value = '<%=request.getParameter("name") %>' name="a1"/>
	<jsp:param value = '<%=request.getParameter("password") %>' name="a2"/>
</jsp:include>
</body>
</html>