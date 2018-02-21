<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>图书查询</title>
<style type="text/css">
.admin {
	position: absolute;
	top: 20px;
	right: 20px;
	text-decoration: none;
	font-weight: bold;
	color: red;
}

.form {
	position: absolute;
	top: 60px;
	left: 560px;
	color: green;
	font-weight: bold;
}

.cen {
	position: absolute;
	top: 30px;
	left: 545px;
	color: red;
	font-weight: bold;
	font-family: "隶书";
	font-size: 24px;
}
</style>
</head>
<body bgcolor="#FFFCCC">
	<center class="cen">文经学院图书馆登陆</center>
	<a href="admin" class="admin">后台登陆</a>
	<form action="checklogin" method="post" class="form">
		<pre>
学号：<input type="text" name="number" /><br />
姓名：<input type="text" name="name" /><br />
        <input type="submit" value="登陆" style="color: green;" />&nbsp;&nbsp;&nbsp;<input
				type="reset" value="重置" style="color: green;" />
</pre>
	</form>
</body>
</html>