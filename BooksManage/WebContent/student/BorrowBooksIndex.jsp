<%@page import="java.sql.ResultSet"%>
<%@page import="booksManage.Dao.DBServer"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
.search{
position: absolute;
top: 100px;
left: 400px;
color:red;
font-weight: bold;
font-size: 24px;
}
.content{
position: absolute;
top: 1px;
left: 135px;
color: green;
font-size: 24px;
}
.sub{
position: absolute;
top: 1px;
left: 420px;
color: red;
font-size: 24px;
font-weight: bold;
}
.table{
position: absolute;
top: 200px;
left: 430px;
text-align: center;
color: green;
font-size: 20px;
font-weight: bold;
}
</style>
<s:head/>
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
<div class="search">
	<s:form action="searchbook" method="post">
		<s:select list="#{'a':'����','b':'ͼ����' }" name="type" cssStyle="color:green;font-weight:bold;font-size:24px;"></s:select>
		<s:textfield name="content" cssClass="content"></s:textfield>
		<s:submit value="����" cssClass="sub"></s:submit>
	</s:form>
</div>
<table border="1px;" class="table">
<tr><th>ͼ����</th><th>ͼ������</th><th>ͼ������</th><th>����</th><th>����</th></tr>
<%
	DBServer dbs= new DBServer();
	ResultSet rs=dbs.SelectDatabase("books");
	while(rs.next()){
		int sum=rs.getInt("sum");
		if(sum!=0){
			%>
				<tr>
					<td><%=rs.getString("id") %></td>
					<td><%=rs.getString("bookname") %></td>
					<td><%=rs.getString("type") %></td>
					<td><%=sum %></td>
					<td>
						<form action="borrowbookaction" method="post">
							<input type="hidden" value="<%=rs.getString("id") %>" name="bookid" />
							<input type="submit" value="����" style="color: red;font-weight: bold;"/>
						</form>
					</td>
				</tr>
			<%
		}else{
			%>
			<tr>
				<td><%=rs.getString("id") %></td>
				<td><%=rs.getString("bookname") %></td>
				<td><%=rs.getString("type") %></td>
				<td><%=sum %></td>
				<td style="font-style: italic;color: red;">��ʱ���ܽ���</td>
			</tr>
		   <%
		}
	}
%>
</table>
</body>
</html>