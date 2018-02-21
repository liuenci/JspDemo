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
		String name = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		//获取登陆保存时长
		String time = request.getParameter("time");
		if (name.equals("")) {
			out.println("<center>欢迎:<a href='register.jsp'>游客</a></center>");
		}else if(name.equals("admin")&&pwd.equals("123456")){
			out.println("<center>欢迎:<a href='register.jsp'>"+name+"</a></center>");
			/* Cookie c = new Cookie("name",name);
			c.setMaxAge(10);
			response.addCookie(c); */
			
			
			//将用户信息保存到session中
			session.setAttribute("uname", name);
			session.setAttribute("pwd", pwd);
			session.setMaxInactiveInterval(Integer.parseInt(time));
			response.sendRedirect("main.jsp");
		}else{
			out.println("登陆失败,3秒后自动跳转到登陆界面");
			//销毁session对象
			session.invalidate();
			//设置页面自动跳转
			response.setHeader("refresh","3;url=login.jsp");
		}
	%>
</body>
</html>