<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>fmt:formatNumber 使用指定的格式或精度格式化数字</h1>
<%--使用指定的格式或精度格式化数字 --%>
<c:set var="balance" value="120000.2309" />
<br />格式化数字 (1)货币: <fmt:formatNumber type="currency" value="${balance}"/>
<br />格式化数字 (2)数字: <fmt:formatNumber type="number" maxIntegerDigits="3" value="${balance}" />
<br />格式化数字 (3)数字: <fmt:formatNumber type="number" maxFractionDigits="3" value="${balance}" />
<br />格式化数字 (4)数字: <fmt:formatNumber type="number" groupingUsed="false" value="${balance}" />
<br />格式化数字 (5)数字: <fmt:formatNumber type="number"  pattern="###.###E0" value="${balance}" />
<br />格式化数字 (6)百分比: <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${balance}" />
<br />格式化数字 (7)百分比: <fmt:formatNumber type="percent" minFractionDigits="10" value="${balance}" />
<br />格式化数字 (8)百分比: <fmt:formatNumber type="percent" groupingUsed="false" value="${balance}" />

<h1>fmt:parseNumber 解析一个代表着数字，货币或百分比的字符串</h1>
<%--解析一个代表着数字，货币或百分比的字符串 --%>
<c:set var="balance" value="1250003.350" />
<fmt:parseNumber var="i" type="number" value="${balance}" />
数字解析 (1) : <c:out value="${i}" />
<br />
<fmt:parseNumber var="i" integerOnly="true"  type="number" value="${balance}" />
数字解析 (2) : <c:out value="${i}" />

<h1>fmt:formatDate 日期格式化</h1>
<c:set var="now" value="<%=new java.util.Date()%>" />
<br />日期格式化 (1): <fmt:formatDate type="time"  value="${now}" />
<br />日期格式化 (2): <fmt:formatDate type="date"  value="${now}" />
<br />日期格式化 (3): <fmt:formatDate type="both" value="${now}" />
<br />日期格式化 (4): <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" />
<br />日期格式化 (5): <fmt:formatDate type="both"  dateStyle="medium" timeStyle="medium" value="${now}" />
<br />日期格式化 (6): <fmt:formatDate type="both"  dateStyle="long" timeStyle="long" value="${now}" />
<br />日期格式化 (7): <fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss"  value="${now}" />
<br />日期格式化 (8): <fmt:formatDate pattern="yyyy/MM/dd hh:mm:ss"  value="${now}" />

<h1>fmt:parseDate 日期解析</h1>
<c:set var="oneDay" value="27-9-2017" />

<fmt:parseDate value="${oneDay}" var="parsedEmpDate"  pattern="dd-MM-yyyy" />
<p>解析后的日期为: <c:out value="${parsedEmpDate}" /></p>
日期格式化 (5): <fmt:formatDate type="both"  dateStyle="medium" timeStyle="medium" value="${parsedEmpDate}" />

</body>
</html>