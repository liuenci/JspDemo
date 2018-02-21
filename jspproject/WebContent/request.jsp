<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请求对象</title>
</head>
<body bgcolor="<%=request.getParameter("color")%>">
	<%
		int a = 10;
		int b = 20;
		out.println(a + b);
	%>
	request 对象方法
	<br/>
	获取请求方式:<%=request.getMethod() %><br/>
	获取请求资源:<%=request.getRequestURI() %><br/>
	<%=request.getRequestURL()%><br/>
	获取请求文件名:<%=request.getServletPath() %><br/>
	获取请求服务器:<%=request.getServerName() %><br/>
	获取服务器端口:<%=request.getServerPort() %><br/>
	获取服务器ip地址:<%=request.getRemoteAddr() %><br/>
	获取客户端主机名:<%=request.getRemoteHost() %><br/>
	获取表单提交信息:<br/>
	<%request.setCharacterEncoding("UTF-8");%>
</body>
</html>