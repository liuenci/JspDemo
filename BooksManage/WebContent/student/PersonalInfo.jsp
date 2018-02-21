<%@page import="java.sql.ResultSet"%>
<%@page import="booksManage.Dao.DBServer"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>个人信息主页</title>
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
.stuback{
position: absolute;
top: 50px;
right: 20px;
color: red;
text-decoration: none;
}
.cen{
position: absolute;
top: 100px;
left: 650px;
color: red;
font-weight: bold;
font-size: 20px;
}
.ul{
position: absolute;
top: 150px;
left: 610px;
color: green;
font-size: 24px;
font-weight: bold;
font-family: "隶书";
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
<a href="studentback" class="stuback">返回上一页</a>
<center class="cen">个人信息</center>
<ul class="ul">
<%
	DBServer dbs= new DBServer();
	ResultSet rs=dbs.SelectDatabase("student");
	while(rs.next()){
		if(rs.getString("number").equals(number)){
			if(rs.getString("sex").equals("M")){
				%>
				<li>姓名:<%=rs.getString("name") %></li>
				<li>学号:<%=rs.getString("number") %></li>
				<li>性别:男</li>
				<li>班级:<%=rs.getString("classes") %></li>
				<li>所属系:<%=rs.getString("dept") %></li>
				<li>还能借书<%=5-rs.getInt("sum") %>本</li>
			    <%				
			}else{
				%>
				<li>姓名:<%=rs.getString("name") %></li>
				<li>学号:<%=rs.getString("number") %></li>
				<li>性别:女</li>
				<li>班级:<%=rs.getString("classes") %></li>
				<li>所属系:<%=rs.getString("dept") %></li>
				<li>还能借书<%=5-rs.getInt("sum") %>本</li>
			<%
			}
		}
	}
%>
</ul>
</body>
</html>