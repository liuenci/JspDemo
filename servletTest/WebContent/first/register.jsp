<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
</head>
<body>
	<form action="UserServlet" method="post">
		<table border="1">
			<tr>
				<td>address:</td>
				<td><input type="text" name="address"><span></span></td>
			</tr>
			<tr>
				<td>userName:</td>
				<td><input type="text" name="userName"><span></span></td>
			</tr>
			<tr>
				<td>email:</td>
				<td><input type="text" name="email"><span></span></td>
			</tr>
			<tr>
				<td>userAge:</td>
				<td><input type="text" name="userAge"><span></span></td>
			</tr>
			<tr>
				<td>birthday:</td>
				<td><input type="text" name="birthday"><span></span></td>
			</tr>
			<tr>
				<td colspan="2"><center><input type="submit" value="regist">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="reset"></center></td>
			</tr>
		</table>
	</form>
</body>
</html>