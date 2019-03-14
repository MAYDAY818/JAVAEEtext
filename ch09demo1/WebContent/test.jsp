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
	pageContext.setAttribute("temp4",16);
%>
<br>今天的温度是${param.temp}度。
<br>今天的温度是${requestScope.temp1 }度。
<br>今天的温度是${sessionScope.temp2 }度。
<br>今天的温度是${applicationScope.temp3 }度。
<br>今天的温度是${pageScope.temp4 }度。
<br>用户名：${param.userName }
<br>爱好：${paramValues.hobby[0] }
<br>爱好：${paramValues.hobby[1] }
<br>爱好：${paramValues.hobby[2] }
<br>${1+2 }
<br>${1} + ${2}
<br>${15 / 2 }
<br>${15 % 2 }
<br>${param.userName == null }
<br>${not empty param.userName }

</body>
</html>