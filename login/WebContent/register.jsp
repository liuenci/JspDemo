
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jq/jquery-3.2.1.js"></script>
<link href="css/register.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>淘宝账号注册</title>
</head>
<body bgcolor="#FFFCCC">
	<div class="main">
		<div class="registerinfor">
			<span class="name">淘宝账号注册</span>
			<form action="register_ok.jsp" method="post">
				<label>用户名:&nbsp;</label><input type="text" placeholder="请输入用户名" name="uname">
				<br />
				<br />
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</label><input type="text" placeholder="请输入密码" name="pwd">
				<br />
				<br />
				<label>手机号:&nbsp;</label><input type="text" placeholder="请输入手机号" name="phone">
				<br />
				<br />
				<label>邮箱号:&nbsp;</label><input type="text" placeholder="请输入邮箱号" name="email">
				<br />
				<br/>
				<img src="checkCode.jsp">
				<!-- <input type="image" src="checkCode.jsp"> -->
				<input type="text" placeholder="请输入验证码"/>
				
				<br/>
				<input type="submit" value="注册" class="re" style="color: green;">
				<input type="reset" value="重置" style="color: green;">
			</form>
		</div>
	</div>
	
</body>
</html>