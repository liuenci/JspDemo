<%@page import="java.sql.ResultSet"%>
<%@page import="booksManage.Dao.DBServer"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>ȫ��ͼ��</title>
<style type="text/css">
.logout{
position: absolute;
top: 10px;
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
.cen{
position: absolute;
top: 30px;
left: 580px;
color: green;
font-family: "����";
font-weight: bold;
font-size: 24px;
}
.back{
position: absolute;
top: 50px;
right: 20px;
text-decoration: none;
color: red;
}
.table{
position: absolute;
top: 80px;
left: 500px;
}
td{
color: green;
text-align: center;
font-family:"����";
}
</style>
</head>
<body bgcolor="#FFFCCC">
<%
	Object obj=session.getAttribute("admin");
	if(null==obj){
		request.getRequestDispatcher("../login.jsp").forward(request,response);
	}
%>
<div class="wel">��ã�<%=obj %></div>
<a href="back" class="logout">�˳�</a>
<div class="cen">ȫ��ͼ����Ϣ</div>
<a href="back1" class="back">������һҳ</a>
<table border="1px;" class="table">
<tr><th>ͼ����</th><th>ͼ������</th><th>ͼ������</th><th>ͼ������</th></tr>
<%
	DBServer dbs= new DBServer();
	ResultSet rs=dbs.SelectDatabase("books");
	while(rs.next()){
		%>
			<tr>
				<td><%=rs.getString("id") %></td>
				<td><%=rs.getString("bookname") %></td>
				<td><%=rs.getString("type") %></td>
				<td><%=rs.getInt("sum") %></td>
			</tr>
		<%
	}
%>
</table>
</body>
</html>