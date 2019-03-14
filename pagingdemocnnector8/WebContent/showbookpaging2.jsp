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
	<c:forEach items="${subBookList }" var="book">
		<p>${book.bookName }&emsp;${book.bookAuth }&emsp;
			${book.bookPublisher }&emsp; ${book.bookPrice }&emsp;</p>
		<img src="${book.bookImageUrl }" />
	</c:forEach>
	
	<c:if test="${currentPage > 1 }">
		<a href="BookServletPaging2?currentPage=${currentPage - 1 }">上一页</a>
	</c:if>
	<c:if test="${currentPage < pageCount }">
		<a href="BookServletPaging2?currentPage=${currentPage + 1 }">下一页</a>
	</c:if>
	<br>
	<c:forEach begin="1" end="${pageCount }" var="i">
		<a href="BookServletPaging2?currentPage=${i }"> ${i } </a>
	</c:forEach>
</body>
</html>