<%@page import="cn.dao.student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页面</title>
</head>
<body>
	<table border="1" style="width: 500px">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>性别</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${stuList }" var="studentBean">
			<tr>
				<td>${studentBean['stu_id']}</td>
				<td>${studentBean['stu_name']}</td>
				<td>${studentBean['stu_sex']}</td>
				<td>${studentBean['stu_age']}</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="StudentServlet?page=1&size=5">第一页</a>&nbsp; <a
			href="StudentServlet?page=${last }&size=5">上一页</a>&nbsp; <a
			href="StudentServlet?page=${next }&size=5">下一页</a>&nbsp; <a
			href="StudentServlet?page=${pages }&size=5">最后一页</a>
	<p>
</body>
</html>