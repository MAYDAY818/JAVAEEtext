<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>
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
<!-- cart -->
</head>
<body>
<%@ include file="header.jsp" %>
	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
			<h2>My Shopping Cart</h2>
			
			
			<c:forEach items="${subOrderDetailList }" var="orderDetail">
			
			<div class="cart-header">
				<div class="close1"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="${orderDetail.orderdetail_class_cake.cake_class_image_url }" class="img-responsive" alt="">
					</div>
					<div class="cart-item-info">
						<h3><a href="#"> ${orderDetail.orderdetail_class_cake.cake_class_name } </a><span>Price: ${orderDetail.orderdetail_class_cake.cake_class_price }</span></h3>
						<ul class="qty">
							<li><p>数量： ${orderDetail.orderdetail_class_count }</p></li>
							<li><p>规格：${orderDetail.orderdetail_class_cake.cake_class_size }Kg</p></li>
						</ul>
						<div class="delivery">
							<p>运费 : $10.00</p>
							<span>Delivered in 1-1:30 hours</span>
							<div class="clearfix"></div>
							<a href="OrderListServletDelete?orderlistid=${orderDetail.orderdetail_class_id }"><font color="red">删除</font></a>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			
			
			</c:forEach>

					
		</div>
	</div>
	<!--//checkout-->	
	<%@ include file="footer.jsp" %>
</body>
</html>