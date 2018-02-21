<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		Cookie name = new Cookie("name", URLEncoder.encode("帅南哥","utf-8"));
		Cookie age = new Cookie("age", "18");
		Cookie birthday = new Cookie("birthday", "1999-01-01");
		Cookie phone = new Cookie("phone", "13272135322");
		response.addCookie(name);
		response.addCookie(age);
		response.addCookie(birthday);
		response.addCookie(phone);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	%>
</body>
</html>