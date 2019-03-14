<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="FormServlet" method="post">

	<!-- 多选框  如果未设置value，选中值默认为on-->
	<input type="checkbox" value="value1" name="hobby">篮球
	<input type="checkbox" value="value2" name="hobby">足球
	<input type="checkbox"  name="hobby">排球
	
	<!-- 多行文本域 -->
	<textarea name="area">内容</textarea>
	
	<!-- 下拉列表 -->
	<select name="sel">
		<option value="val">选项1</option>
		<option value="val2">选项2</option>
		<option value="val3">选项3</option>
	</select>
	
	<!-- 隐藏域 -->
	<input type="hidden" name="userId" value="123456">
	
	<!-- 单选按钮 -->
	<input type="radio" name="sex" value="0">男
	<input type="radio" name="sex" value="1">女
	
	<input type="submit" value="提交">
</form>
</body>
</html>