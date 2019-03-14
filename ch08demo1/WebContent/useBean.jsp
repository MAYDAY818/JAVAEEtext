<%@page import="bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="s1" scope="session" class="bean.StudentBean"></jsp:useBean>
<jsp:setProperty property="stuNo" name="s1"/>
<jsp:setProperty property="stuName" name="s1" />
<%--获取并打印 --%>
<jsp:getProperty property="stuNo" name="s1"/>
<jsp:getProperty property="stuName" name="s1"/>
<%--
	StudentBean s1 = new StudentBean();
	session.setAttribute("s1",s1);
--%>
</body>
</html>