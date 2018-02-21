<%@page import="java.net.URLDecoder"%>
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
		//创建cookie
		Cookie c = new Cookie("un", "admin");
		//添加cookie，写入客户端
		response.addCookie(c);
		//保存中文
		Cookie c1 = new Cookie("name", URLEncoder.encode("熊主席", "utf-8"));
		response.addCookie(c1);
		out.println(c1.getValue());
		Cookie c2 = new Cookie("name", URLDecoder.decode(c1.getValue(), "utf-8"));
		out.println(c2.getValue());
		//
		Cookie[] cs = request.getCookies();
		if (cs != null) {
			for (Cookie c3 : cs) {
				String name = c3.getName();
				String value = c3.getValue();
				out.println(name + ":" + value);
				out.println("<br/>");
			}
		}
	%>
</body>
</html>