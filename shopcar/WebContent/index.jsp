<%@page import="java.util.Map.Entry"%>
<%@page import="cn.bean.Product"%>
<%@page import="java.util.Map"%>
<%@page import="cn.bean.ProductRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<style type="text/css">
	ul{
		list-style: none;		
	}
	ul li{
		width: 200px;
		height: 350px;
		float: left;
		margin: 10px;
		border: 1px solid gray;
	}
	ul li p{
		font-size: 14px;
		padding-left: 20px;
	}
	ul li img{
		width: 200px;
		height: 200px;
	}
	ul li p a{
		text-decoration: none;
		color: red;
		position: relative;
	}
	ul li p a:after{
		content: "";
		height: 3px;
		background: red;
		position: absolute;
		top: 100%;
		left: 50%;
		width: 0%;
		transition: all 0.8s;
	}
	ul li p a:hover:after{
		left: 0%;
		width: 100%;
	}

</style>
</head>
<body>
	<center><h3>商品列表</h3></center>
	<hr>
	<ul>

		<%
			//获取商品所有信息
			Map<Integer, Product> pm = ProductRepository.getProducts();
			//循环遍历商品信息
			for (Entry<Integer, Product> e : pm.entrySet()) {
				Product p = e.getValue();
		%>
		<li>
			<img alt="<%=p.getName() %>" src="images/Koala.jpg">
			<p>商品编号:<%=p.getPid() %></p>
			<p>商品名称:<%=p.getName() %></p>
			<p>商品价格:<%=p.getPrice() %></p>
			<p><a href="Buy.jsp?pid=<%=p.getPid()%>">添加到购物车</a></p>
		</li>
		<%
			}
		%>

	</ul>
</body>
</html>