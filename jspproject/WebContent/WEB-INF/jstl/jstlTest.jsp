<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 获取标题和内容 -->
	<h1>${title}</h1>
	<p>${content}</p>

	<!-- 获取学生信息 -->
	<p>学生名字:${bean.name }</p>
	<p>学生性别:${bean.sex }</p>
	<p>学生年龄:${bean.age }</p>
	<hr>
	获取数组中元素:${arr[2] }
	<br> 获取集合中的一个元素:${list[0] }

	<!-- empty的使用 -->
	<br> ${empty param.name?"用户名不存在":"admin" }

	<!-- 获取cookie的值 -->
	<br>获取cookie的值:${cookie.sessionId.value }

	<!-- 获取map的一个值 -->
	<br>获取Map集合中的一个元素:${map.two }
	<br>
	<!-- 设置uname，类似于req.setAttribute(String,String) -->
	<c:set var="uname" value="张三"></c:set>
	<c:out value="${uname}"></c:out>
	
	<br>
	<!-- if的使用 -->
	<c:if test="${uname!=张三}" var="n" scope="page">
		${uname}
	</c:if>
	<br>
	
	<!-- choose的使用 -->
	<c:choose>
		<c:when test="${param.num%9==0}">恭喜中一等奖</c:when>
		<c:when test="${param.num%7==0}">恭喜中二等奖</c:when>
		<c:when test="${param.num%5==0}">恭喜中三等奖</c:when>
		<c:otherwise>恭喜你没中奖</c:otherwise>
	</c:choose>
	<br>
	
	<!-- 使用循环获取list里面的值 -->
	<c:forEach items="${list}" begin="0" end="2" var="cur">
		<p>${cur}</p>
	</c:forEach>
	<br>
	
	<!-- 使用循环获取map里面的值 -->
	<c:forEach items="${map}" begin="0" end="2" var="cur1">
		<c:forEach items="${cur1.value}" var="cur2">
			<p>${cur1.key}的值是${cur2}</p>
		</c:forEach>
	</c:forEach>
	
	<!-- forTokens -->
	<c:forTokens items="中国人，美国人，英国人" delims="，" var="token">
	${token}&nbsp;
	</c:forTokens>
</body>
</html>