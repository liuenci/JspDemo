<%@page import="java.sql.ResultSet"%>
<%@page import="booksManage.Dao.DBServer"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>借还书记录</title>
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
.table{
position: absolute;
top: 150px;
left: 380px;
}
th{
text-align: center;
color: green;
}
td{
color: green;
font-weight: bold;
font-family: "隶书";
font-size: 24px;
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
<center class="cen">借书、还书记录</center>
<table border="1px;" class="table">
<tr><th>书名</th><th>图书编号</th><th>时间</th><th>状态</th><th>操作</th></tr>
<%
	DBServer dbs= new DBServer();
	ResultSet rs=dbs.SelectDatabase("record");
	while(rs.next()){
		if(rs.getString("number").equals(number)){
			%>
			<tr>
				<td><%=rs.getString("bookname") %></td>
				<td><%=rs.getString("bookid") %></td>
				<td><%=rs.getString("time") %></td>
				<td><%=rs.getString("say") %></td>
				<td>
					<form action="deleterecord" method="post">
						<input type="hidden" value="<%=rs.getInt("id") %>" name="recordid" />
						<input type="submit" value="删除" style="color: red;"/>
					</form>
				</td>
			</tr>
		<%			
		}
	}
%>
</table>
</body>
</html>