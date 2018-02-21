<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<c:choose>
		<c:when test="${param.username.length()<10 }">用户名过短</c:when>
		<c:otherwise>用户名正常</c:otherwise>
	</c:choose>
	<br>
	<c:choose>
		<c:when test="${param.useraddress eq '株洲'}">您是本地人</c:when>
		<c:otherwise>您不是本地人</c:otherwise>
	</c:choose>
	<br>
	<c:choose>
		<c:when test="${param.usersex == '男' }">帅哥</c:when>
		<c:when test="${param.usersex eq '女' }">美女</c:when>
		<c:otherwise>人妖</c:otherwise>
	</c:choose>
	<br>
	<c:choose>
		<c:when test="${fn:startsWith(param.userphone,'132') }">联通</c:when>
		<c:when test="${fn:startsWith(param.userphone,'142') }">移动</c:when>
		<c:when test="${fn:startsWith(param.userphone,'152') }">电信</c:when>
	</c:choose>
</body>
</html>