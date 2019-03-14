<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		Object object = session.getAttribute("shoppingCart");
		if(object == null) {
			out.print("购物车是空的");
		}else {
			List<String> shoppingCart = (ArrayList<String>)object;
			for(String bookName:shoppingCart) {
				out.print(bookName+"<br>");
			}
		}
%>
</body>
</html>