<%@page import="java.sql.ResultSet"%>
<%@page import="booksManage.Dao.DBServer"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�������</title>
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
top: 50px;
left: 580px;
color: red;
}
.table{
position: absolute;
top: 120px;
left: 530px;
color: green;
}
.empty{
position: absolute;
top: 200px;
left: 550px;
color: green;
font-weight: bold;
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
<div class="wel">��ã�<%=obj %></div>
<a href="back" class="back">�˳�</a>
<a href="studentback" class="stuback">������һҳ</a>
<center class="cen">�����ǵ�Ҫ��Ŷ</center>
<%
	DBServer dbs= new DBServer();
	ResultSet empty=dbs.SelectDatabase("stubook");
	//countΪ0��ʾû��Ҫ������
	int count=0;
	while(empty.next()){
		count++;
	}
	if(0==count){
		%>
			<center class="empty">��û��Ҫ�����飡������</center>
		<%
	}else{
		%>
			<table border="1px;" class="table">
				<tr>
					<td>����</td><td>ͼ����</td><td>����</td>
				</tr>
				<%
					ResultSet rs=dbs.SelectDatabase("stubook");
					while(rs.next()){
						if(rs.getString("number").equals(number)){
							%>
								<tr>
									<td><%=rs.getString("bookname") %></td>
									<td><%=rs.getString("bookid") %></td>
									<td>
										<form action="returnbookaction" method="post">
											<input type="hidden" value="<%=rs.getInt("id") %>" name="stubookid" />
											<input type="hidden" value="<%=rs.getString("bookid") %>" name="bookid"/>
											<input type="submit" value="����" style="font-family: '����';color: green;font-weight: bold;" /> 
										</form>
									</td>
								</tr>
							<%
						}
					}
				%>
			</table>
		<% 
	}
%>
</body>
</html>