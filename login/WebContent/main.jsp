<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFCCC">
	<%
		//设置页面字符编码
		//request.setCharacterEncoding("utf-8");
		//获取用户名
		String name = session.getAttribute("uname").toString();
		String pwd = session.getAttribute("pwd").toString();
		out.println("<center>欢迎:"+name+"</center>");
	%>

</body>
</html>