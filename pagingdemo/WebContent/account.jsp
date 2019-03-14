<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Account</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->	
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<script type="text/javascript">  
//第一步：  
/*XMLHTTPRequest是AJAX应用中的核心API，它被js调用以向服务器发送请求，并异步接收服务器返回的数据后，更新局部页面。使用AJAX功能时，首先要在js中创建XMLHTTPRequest对象：*/  
  <!--  function createXMLHttpRequest() {    //创建XMLHttpRequest
	    try {
	        return new XMLHttpRequest();            //直接创建对象，不适用与IE5,IE6
	    } catch (e) {
	        try {
	            return new ActiveXObject("Msxml2.XMLHTTP");//对于不适用的，创建合适的对象
	        } catch (e) {
	            return new ActiveXObject("Microsoft.XMLHTTP");
	        }
	    }
	}
	
	function send() {
	    var xmlHttp = createXMLHttpRequest();
	
	    xmlHttp.onreadystatechange = function () {
	       if (xmlHttp.readyState === 4 && xmlHttp.status == 200) {//判断xmlHttp的状态是否完毕
	            if(xmlHttp.responseText == "true") {//判断ajax从Servlet中返回的信息，即判断用户名是否存在。 
	                document.getElementById("email").innerHTML= "邮箱已被注册!";      //弹出警告信息，告知不可适用该用户名
	                document.all("register").disabled=true; //将注册按钮关闭，无法点击
	            }else {                 
	                document.getElementById("Username_Error_Massage").innerHTML= "账号可用!";
	                document.all("register").disabled=false;//开启注册按钮
	            }
	        }
	    }
	    var method = "POST";        //定义传输方式
	    var url="AccountCheckServlet?timeStamp="+new Date().getTime();//定义对应的URL，为了避免浏览器的缓存造成干扰，加上时间戳
	    xmlHttp.open(method, url, true);       
	    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	    var useremail = document.getElementById("email").value;
	    console.log(useremail);
	    if(useremail===undefined || useremail === null || useremail === ""){   //判断用户名是否为空
	        alert("邮箱不能为空！");       // 弹出警告信息
	    }
	    xmlHttp.send("useremail=" + useremail);       //发送信息
	}
	-->
</script>  
<!-- cart -->
</head>
<body>
	<%@ include file="header.jsp" %>
	<!--account-->
	<div class="account">
		<div class="container">
			<div class="register">
				<form action="UserSignUpServlet" method="post"> 
					<div class="register-top-grid">
						<h3>Personal information</h3>
						<div class="input">
							<span>Name<label>*</label></span>
							<input type="text" name="name"> 
						</div>
						<div class="input">
							<span>Email Address<label>*</label></span>
							<input type="text"  id="email" name="email" onblur="send()"> 
						</div>
						<a class="news-letter" href="#">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Sign Up for Newsletter</label>
						</a>
						<div class="clearfix"> </div>
					</div>
				    <div class="register-bottom-grid">
						<h3>Login information</h3>
						<div class="input">
							<span>Password<label>*</label></span>
							<input type="password" name="password">
						</div>
					</div>
					<div class="clearfix"> </div>
				<div class="register-but">
					   <input type="submit" value="submit" id="checkusername">
					   <div class="clearfix"> </div>
				</div>
				</form>
				
			</div>
	    </div>
	</div>
	<!--//account-->
	<%@ include file="footer.jsp" %>
</body>
</html>