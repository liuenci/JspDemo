<%@page import="java.sql.ResultSet"%>
<%@page import="booksManage.Dao.DBServer"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>检索 结果</title>
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
.searchcontent{
position: absolute;
top: 70px;
left: 30px;
color: red;
font-weight: bold;
font-size: 20px;
}
.cen{
position: absolute;
top: 100px;
left: 650px;
color: green;
font-size: 20px;
}
.empty{
position: absolute;
top: 200px;
left: 480px;
color: red;
font-size: 24px;
}
.table{
position: absolute;
top: 200px;
left: 480px;
}
</style>
</head>
<body bgcolor="#FFFCCC">
<%
	Object obj=session.getAttribute("userName");
	if(null==obj){
		request.getRequestDispatcher("../login.jsp").forward(request,response);
	}
	String content=(String)session.getAttribute("content");
	String type=(String)session.getAttribute("type");
%>
<div class="wel">你好，<%=obj %></div>
<a href="back" class="back">退出</a>
<a href="http://localhost:8080/BooksManage/borrowbook" class="stuback">返回上一页</a>
<div class="searchcontent">您搜索的关键字为:<%=content %></div>
<center class="cen">搜索结果</center>
<%
	String empty=(String)session.getAttribute("empty");
	if("yes".equals(empty)){
		%>
			<h2 class="empty">Sorry!!!找不到此关键字对应的图书名字</h2>
		<%
	}else{
		DBServer dbs= new DBServer();
		ResultSet rs=dbs.SelectDatabase("books");
		%>
		<table border="1px;" class="table">
			<tr>
				<th>图书编号</th><th>图书名称</th><th>图书类型</th><th>图书数量</th><th>操作</th>
			</tr>
		<%
		if("a".equals(type)){
			while(rs.next()){
				if(-1!=rs.getString("bookname").indexOf(content)){
					if(0==rs.getInt("sum")){
						%>
							<tr>
								<td><%=rs.getString("id") %></td>
								<td><%=rs.getString("bookname") %></td>
								<td><%=rs.getString("type") %></td>
								<td>0</td>
								<td style="color: red;">暂时不能借书</td>
							</tr>
						<%
					}else{
						%>
						<tr>
							<td><%=rs.getString("id") %></td>
							<td><%=rs.getString("bookname") %></td>
							<td><%=rs.getString("type") %></td>
							<td><%=rs.getInt("sum") %></td>
							<td>
								<form action="borrowbookaction" method="post">
									<input type="hidden" value="<%=rs.getString("id") %>" name="bookid"  />
									<input type="submit" value="借书" style="color: red;"/>
								</form>
							</td>
						</tr>
					<%
					}
				}
			}
		}else{
			while(rs.next()){
				if(-1!=rs.getString("id").indexOf(content)){
					if(0==rs.getInt("sum")){
						%>
							<tr>
								<td><%=rs.getString("id") %></td>
								<td><%=rs.getString("bookname") %></td>
								<td><%=rs.getString("type") %></td>
								<td>0</td>
								<td style="color: red;">暂时不能借书</td>
							</tr>
						<%
					}else{
						%>
						<tr>
							<td><%=rs.getString("id") %></td>
							<td><%=rs.getString("bookname") %></td>
							<td><%=rs.getString("type") %></td>
							<td><%=rs.getInt("sum") %></td>
							<td>
								<form action="borrowbookaction" method="post">
									<input type="hidden" value="<%=rs.getString("id") %>" name="bookid" />
									<input type="submit" value="借书" style="color: red;"/>
								</form>
							</td>
						</tr>
					<%
					}
				}
			}
		}
	%>
	</table>
	<%
	}
%>
</body>
</html>