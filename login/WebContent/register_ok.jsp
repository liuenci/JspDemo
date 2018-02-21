<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册信息</title>
</head>
<body bgcolor="#FFFCCC">
	<center>
	<%
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		if(uname.equals("")){
			out.print("用户名不能为空");
		}else if(pwd.equals("")){
			out.println("密码不能为空");
		}else if(phone.equals("")){
			out.println("手机号不能为空");
		}else if(email.equals("")){
			out.println("邮箱号不能为空");
		}else{
			//将用户信息保存到session
			session.setAttribute("uname", uname);
			//进入主页
			//response.sendRedirect("main.jsp");
			out.println("注册成功,欢迎:"+uname+","+"<a href='main.jsp'>前往我的主页:</a>");
		}
	%>
	</center>
</body>
</html>