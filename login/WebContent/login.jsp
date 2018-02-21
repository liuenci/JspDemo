<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/register.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
</head>
<body bgcolor="#FFFCCC">
	<div class="main">
		<div class="registerinfor">
			<span class="name">淘宝账号登陆</span>
			<form action="check.jsp" method="post">
				<label>用户名:&nbsp;</label><input type="text" placeholder="请输入用户名" name="uname">
				<br />
				<br />
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</label><input type="text" placeholder="请输入密码" name="pwd">
				<br />
				<br />
				<input type="radio" name="time" value="5" checked="checked">5秒
				<input type="radio" name="time" value="10">10秒
				<input type="radio" name="time" value="120">120秒
				<input type="radio" name="time" value="9999999">永久登陆<br/><br/>
				<input type="submit" value="登陆" class="re" style="color: green;">
				<input type="reset" value="重置" style="color: green;">
			</form>
		</div>
	</div>
	
</body>
</html>