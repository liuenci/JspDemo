<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test1.jsp" method="post">
		<table border="1">
			<tr>
				<td>姓名:</td>
				<td><input type="text" name="username" />
			</tr>
			<tr>
				<td>地址:</td>
				<td><input type="text" name="useraddress" />
			</tr>
			<tr>
				<td>性别:</td>
				<td><input type="text" name="usersex" />
			</tr>
			<tr>
				<td>电话:</td>
				<td><input type="text" name="userphone" /></td>
			</tr>
			<tr>
				<center>
				<td colspan="2"><input type="submit" value="提交" /></td>
				</center>
			</tr>
		</table>
	</form>
</body>
</html>