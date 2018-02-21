<%@page import="java.net.URLDecoder"%>
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		if (cookies != null) {
			for(int i=0;i<cookies.length;i++){
				cookie = cookies[i];
				out.print(URLDecoder.decode(cookie.getValue(), "utf-8") + " <br>");
				out.print("------------------------------------<br>");
			}
			
		}
	%>
</body>
</html>