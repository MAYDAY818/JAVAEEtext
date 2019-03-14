<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page session ="ture"%>
<%@ page buffer="12kb"%>
<%@ page autoFlush="ture"%>
<%@ page info="a text directtive jsp page"%>
<%@ page isErrorPage="flase"%>
<%@ page errorPage="erroe.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>use page directive</h1>
    <%=new Date().toLocaleString()%>

</body>
</html></html>