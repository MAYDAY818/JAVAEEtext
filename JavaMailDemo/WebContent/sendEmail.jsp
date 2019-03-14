<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function changefm(){
	var fm = document.getElementById("fm");
	fm.disabled = false;
}
</script>
</head>
<body>
<form action="sendEmail.do" method="post">
	<table>
		<tr>
			<td>发件人：</td>
			<td><input type="text" name="fm" id="fm" value="zhangsan_email@163.com" disabled="disabled" /></td>
		</tr>
		<tr>
			<td>收件人：</td>
			<td><input type="text" name="tm" id="tm" /></td>
		</tr>
		<tr>
			<td>主题：</td>
			<td><input type="text" name="title" /></td>
		</tr>
		<tr>
			<td>内容：</td>
			<td>
				<textarea name="content" cols="20" rows="5"></textarea>
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="发送" onclick="changefm()"/></td>
		</tr>
	</table>
</form>
</body>
</html>