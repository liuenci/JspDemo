<%@page import="java.sql.ResultSet"%>
<%@page import="booksManage.Dao.DBServer"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>������Ϣ��ҳ</title>
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
font-family: "����";
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
font-family: "����";
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
<div class="wel">��ã�<%=obj %></div>
<a href="back" class="back">�˳�</a>
<a href="studentback" class="stuback">������һҳ</a>
<center class="cen">������Ϣ</center>
<ul class="ul">
<%
	DBServer dbs= new DBServer();
	ResultSet rs=dbs.SelectDatabase("student");
	while(rs.next()){
		if(rs.getString("number").equals(number)){
			if(rs.getString("sex").equals("M")){
				%>
				<li>����:<%=rs.getString("name") %></li>
				<li>ѧ��:<%=rs.getString("number") %></li>
				<li>�Ա�:��</li>
				<li>�༶:<%=rs.getString("classes") %></li>
				<li>����ϵ:<%=rs.getString("dept") %></li>
				<li>���ܽ���<%=5-rs.getInt("sum") %>��</li>
			    <%				
			}else{
				%>
				<li>����:<%=rs.getString("name") %></li>
				<li>ѧ��:<%=rs.getString("number") %></li>
				<li>�Ա�:Ů</li>
				<li>�༶:<%=rs.getString("classes") %></li>
				<li>����ϵ:<%=rs.getString("dept") %></li>
				<li>���ܽ���<%=5-rs.getInt("sum") %>��</li>
			<%
			}
		}
	}
%>
</ul>
</body>
</html>