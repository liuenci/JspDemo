<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ͼ���ѯ</title>
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
	font-family: "����";
	font-size: 24px;
}
</style>
</head>
<body bgcolor="#FFFCCC">
	<center class="cen">�ľ�ѧԺͼ��ݵ�½</center>
	<a href="admin" class="admin">��̨��½</a>
	<form action="checklogin" method="post" class="form">
		<pre>
ѧ�ţ�<input type="text" name="number" /><br />
������<input type="text" name="name" /><br />
        <input type="submit" value="��½" style="color: green;" />&nbsp;&nbsp;&nbsp;<input
				type="reset" value="����" style="color: green;" />
</pre>
	</form>
</body>
</html>