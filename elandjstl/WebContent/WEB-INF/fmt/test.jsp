<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body bgcolor="#FFFCCC">
	<center>
		<table border="1">
			<tr>
				<td>格式化日期:</td>
				<td><fmt:formatDate value="${date }" pattern="yyyy年MM月dd日" /></td>
			</tr>
			<tr>
				<td>格式化日期:</td>
				<td><fmt:formatDate value="${date }" pattern="yyyy年MM月dd日    HH时mm分ss秒" /></td>
			</tr>
			<tr>
				<td>格式化数字:</td>
				<td><fmt:formatNumber value="${num }" pattern="000000.00"></fmt:formatNumber>
			</tr>
			<tr>
				<td>格式化数字:</td>
				<td><fmt:formatNumber value="${num }" pattern="#####.###"></fmt:formatNumber>
			</tr>
			<tr>
				<td>字符串长度:</td>
				<td>${fn:length(str)}</td>
			</tr>
			<tr>
				<td>营业商:</td>
				<td>${fn:startsWith(str,'132')}</td>
			</tr>
		</table>
	</center>


</body>
</html>