<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>个人图书管理</title>
<style type="text/css">
.back{
position: absolute;
top: 20px;
right: 20px;
text-decoration: none;
color: red;
}
.wel{
position: absolute;
color: green;
font-weight: bold;
font-family: "隶书";
font-size: 24px;
}
.cen{
position: absolute;
top: 35px;
left: 540px;
color: green;
font-weight: bold;
}
.borrow{
position: absolute;
top: 80px;
left: 180px;
text-align: center;
text-decoration: none;
color: red;
font-family: "隶书";
font-weight: bold;
}
.return{
position: absolute;
top: 80px;
right: 180px;
text-align: center;
text-decoration: none;
color: red;
font-family: "隶书";
font-weight: bold;
}
.personal{
position: absolute;
top: 350px;
left: 180px;
text-align: center;
text-decoration: none;
color: red;
font-family: "隶书";
font-weight: bold;
}
.record{
position: absolute;
top: 350px;
right: 180px;
text-align: center;
text-decoration: none;
color: red;
font-family: "隶书";
font-weight: bold;
}
</style>
</head>
<body bgcolor="#FFFCCC">
<%
	Object obj=session.getAttribute("userName");
	if(null==obj){
		request.getRequestDispatcher("../login.jsp").forward(request,response);
	}
	String number=(String)session.getAttribute("number");
%>
<div class="wel">你好，<%=obj %></div>
<a href="back" class="back">退出</a>
<center class="cen">欢迎来到文经学院图书馆</center>
<a href="borrowbook" class="borrow" target="_blank"><img src="pics/borrow.jpg" style="border: 0px;"><br/>借书</a>
<a href="returnbook" class="return" target="_blank"><img src="pics/return.jpg" style="border: 0px;"><br/>还书</a>
<a href="personalinfo" class="personal" target="_blank"><img src="pics/personal.jpg" style="border: 0px;"><br/>个人信息</a>
<a href="record" class="record" target="_blank"><img src="pics/record.jpg" style="border: 0px;"><br/>借还书记录</a>
</body>
</html>