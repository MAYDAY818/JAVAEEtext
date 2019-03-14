<%@page import="java.util.ArrayList"%>
<%@page import="bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>c:catch</h1>
<c:catch var="myException">
	<%
		int j = 10 / 0;
	%>
</c:catch>
<hr />
异常：
<c:out value="${myException}"  />

<h1>c:out</h1>
<c:out value="${myException}"  />
<br />
<c:out value="\""></c:out>
<br />
<c:out value="${aa }" default="not fount"></c:out>
	
<h1>c:set</h1>
<c:set var="num1" value="${4*4}" />
<c:set var="num2">${2*8}</c:set>
<c:out value="num1=${num1}" />
<c:out value="num2=${num2}" />
<br />
<jsp:useBean id="user" class="bean.UserBean" scope="session"></jsp:useBean>
<c:set target="${user}" property="userName" value="zhangsan"  />
<c:set target="${user}" property="password" value="123456" />
<c:set target="${user}" property="sex" value="false" />
<c:set target="${user}" property="limits" value="2" />

<h1>c:remove</h1>
<c:remove var="num1" scope="page" />
<c:out value="num1=${num1}" />
<br />
<c:remove var="num2" scope="session" />
<c:out value="num2=${num2}" />

<h1>c:if c:choose</h1>
<c:if test="${user.userName!=null}">
	hello ${user.userName},
	your password is ${user.password},
	your sex is 
	<c:if test="${user.sex }">男</c:if>
	<c:if test="${!user.sex }">女</c:if>
</c:if>
<br />
<c:choose>
	<c:when test="${user.limits==1}">
		<c:out value="Hello ${user.userName} your are 管理员"></c:out>
	</c:when>
	<c:when test="${user.limits==2}">
		<c:out value="Hello ${user.userName} your are 版主"></c:out>
	</c:when>
	<c:when test="${user.limits==3}">
		<c:out value="Hello ${user.userName} your are 普通会员"></c:out>
	</c:when>
	<c:otherwise>
		<c:out value="Hello ${user.userName} your are 游客"></c:out>
	</c:otherwise>
</c:choose>
<br />
<h1>c:forEach</h1>
<c:forEach begin="3" end="5" step="1" var="i">
	<c:set target="${user}" property="userName" value="user${i}" />
	<c:set target="${user}" property="password" value="password${i}" />
	hello ${user.userName},
	your password is ${user.password}<br />
</c:forEach>
<%
List<UserBean> userList = new ArrayList<UserBean>();
userList.add(user);
userList.add(user);
userList.add(user);
userList.add(user);
userList.add(user);
session.setAttribute("userList", userList);
%>
<table>
<c:forEach items="${userList}" var="u" varStatus="status">
 <!--实现斑马线效果--> 
   <c:if test="${status.count%2==0}" >
      	<tr bgcolor="lightyellow">
	        <td>${u.userName}</td>
			<td>${u.password}</td>
   		</tr> 
    </c:if>
    <c:if test="${status.count%2!=0}" >
       <tr>
			<td>${u.userName}</td>
			<td>${u.password}</td>
   	   </tr> 
    </c:if>
</c:forEach>
</table>

<h1>c:forTokens</h1>
<c:forTokens items="12,34,56,78" delims="," var="va" varStatus="status">
	${status.first}/${status.last}当前：${status.index}<br />
	${va }<br />
</c:forTokens>

<h1>c:url</h1>
<a href="<c:url var="b" value='http://www.baidu.com' />">链接到百度</a>
<c:out value="${b }"></c:out>
<a href="<c:url value='/' />">链接到本站</a>
<a href="/">链接到本站</a>

<h1>c:import</h1>
<c:import var="bai" url="http://www.baidu.com"></c:import>
<%--
<c:out value="${bai }"></c:out>
 --%>
<h1>c:redirect</h1>
<%--
<c:redirect url="a.jsp"></c:redirect>
 --%>
</body>
</html>