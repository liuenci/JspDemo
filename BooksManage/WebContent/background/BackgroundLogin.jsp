<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��̨��½����</title>
<style type="text/css">
.cen{
position: absolute;
top: 30px;
left: 580px;
color: red;
font-weight: bold;
font-family: "����";
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
<center class="cen">ͼ������̨��½</center>
<form action="backchecklogin" method="post" class="form">
<pre>
�˺ţ�<input type="text" name="name"/><br/>
���룺<input type="password" name="pwd"/><br/>
        <input type="submit" value="��½" style="color: green;"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="����" style="color: green;"/>
</pre>
</form>
</body>
</html>