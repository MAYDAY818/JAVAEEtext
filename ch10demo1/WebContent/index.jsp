<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>c:catch</h1>
	<c:catch var="e">
		<%
			int i = 2/1;
		%>
	</c:catch>
	<c:out value="${e }" default="无异常"></c:out>
	<c:out value="${str }" default="空"></c:out>
	
	<h1>c:set</h1>
	<c:set var="num" value="16" scope="page"></c:set>
	<c:set var="num2" scope="session">17</c:set>
	num:<c:out value="${num }"></c:out>
	num2:<c:out value="${num2 }"></c:out>
	<jsp:useBean id="user" class="bean.UserBean"></jsp:useBean>
	<c:set target="${user }" property="name" value="张三"></c:set>
	<c:set target="${user }" property="gender" value="true"></c:set>
	<c:set target="${user }" property="age" value="6"></c:set>
	<c:set target="${user }" property="limit" value="4"></c:set>
	<br>姓名：<c:out value="${user.name }"></c:out>
	<br>性别：<c:out value="${user.gender }"></c:out>
	<br>年龄：<c:out value="${user.age }"></c:out>
	<br>角色：<c:out value="${user.limit }"></c:out>
	
	<h1>c:remove</h1>
	<c:remove var="num2" scope="session"></c:remove>
	num2:<c:out value="${num2}" default="空"></c:out>
	
	<h1>c:if</h1>
	性别：
	<c:if test="${user.gender == true }">男</c:if>
	<c:if test="${user.gender == false }">女</c:if>
	<br>角色：
	<c:choose>
		<c:when test="${user.limit == 1 }">超级管理员</c:when>
		<c:when test="${user.limit == 2 }">普通管理员</c:when>
		<c:when test="${user.limit == 3 }">版主</c:when>
		<c:when test="${user.limit == 4 }">会员</c:when>
		<c:otherwise>游客</c:otherwise>
	</c:choose>
	<h1>c:forEach</h1>
	<c:forEach begin="1" end="5" step="2" var="i">
		大学生${i }
	</c:forEach>
	<%
		List<UserBean> userList = new ArrayList<UserBean>();
		for(int i=0;i<10;i++){
			UserBean u = new UserBean();
			u.setName("zhang"+i);
			if(i%2==0){
				u.setGender(true);
			}else{
				u.setGender(false);
			}
			u.setAge(6+i*2);
			if(i<=5){
				u.setLimit(i);
			}else{
				u.setLimit(i-5);	
			}
			userList.add(u);
		}
		application.setAttribute("userList", userList);
	%>
	<c:forEach items="${userList }" var="u" varStatus="status">
		<br>
		index:${status.index }
		count:${status.count }
		first:${status.first }
		last:${status.last }
		<p>
			${u.name }
			<c:if test="${u.gender==true }">男</c:if>
			<c:if test="${u.gender==false }">女</c:if>
			${u.age }
			<c:choose>
				<c:when test="${u.limit == 1 }">超级管理员</c:when>
				<c:when test="${u.limit == 2 }">普通管理员</c:when>
				<c:when test="${u.limit == 3 }">版主</c:when>
				<c:when test="${u.limit == 4 }">会员</c:when>
				<c:otherwise>游客</c:otherwise>
			</c:choose>
		</p>
	</c:forEach>
	<h1>c:forTokens</h1>
	<c:forTokens items="12,45,78,96,36,45" delims="," var="va">
		${va }
	</c:forTokens>
</body>
</html>