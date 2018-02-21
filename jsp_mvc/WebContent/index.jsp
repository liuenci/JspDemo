<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="page" uri="http://www.liuenci.cn/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
</head>
<body>
	<table border="1" width="500px">
		<tr>
			<th>学生编号</th>
			<th>学生学号</th>
			<th>学生姓名</th>
			<th>学生性别</th>
			<th>手机号码</th>
			<th>生日号码</th>
		</tr>
		<c:forEach items="${pages.data}" var="stu">
			<tr>
				<td>${stu.stuId }</td>
				<td>${stu.stuCode }</td>
				<td>${stu.stuName }</td>
				<td>${stu.stuSex }</td>
				<td>${stu.stuPhone }</td>
				<td>${stu.stuBirthday }</td>
			</tr>
		</c:forEach>
	</table>
	<page:page pages="${pages.pages}" url="StudentServlet?"
		total="${pages.total}" currpage="${pages.currpage}"
		pagesize="${pages.pagesize}" />
</body>
</html>