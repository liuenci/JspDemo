<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>后台登陆界面</title>
<style type="text/css">
.cen{
position: absolute;
top: 30px;
left: 580px;
color: red;
font-weight: bold;
font-family: "隶书";
font-size: 24px;
}
.form{
position: absolute;
top: 60px;
left: 560px;
color: green;
font-weight: bold;
}
</style>
</head>
<body bgcolor="#FFFCCC">
<center class="cen">图书管理后台登陆</center>
<form action="backchecklogin" method="post" class="form">
<pre>
账号：<input type="text" name="name"/><br/>
密码：<input type="password" name="pwd"/><br/>
        <input type="submit" value="登陆" style="color: green;"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="重置" style="color: green;"/>
</pre>
</form>
</body>
</html>