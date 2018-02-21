<%@page import="cn.test.ShopCar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购买商品</title>
</head>
<body>
	<center>
		<h3>购买商品</h3>
	</center>
	<hr>
	<%
		//获取购买商品的id
		int pid = Integer.parseInt(request.getParameter("pid"));
		//判断session中是否有购物车
		ShopCar shopcar = (ShopCar)session.getAttribute("cs");
		if(shopcar!=null){
			//创建购物车对象
			shopcar = new ShopCar();
			session.setAttribute("cs", shopcar);
		}
		shopcar.buy(pid);
	%>
	<p><a href="Carts.jsp" title="点击查看">已经添加到购物车</a></p>
	<p><a href="index.jsp">继续购买</a></p>
</body>
</html>