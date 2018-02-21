<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>添加图书首页</title>
<style type="text/css">
.logout {
	position: absolute;
	top: 10px;
	right: 20px;
	text-decoration: none;
	color: red;
}

.wel {
	position: absolute;
	color: green;
	font-weight: bold;
	font-family: "隶书";
	font-size: 24px;
}

.cen {
	position: absolute;
	top: 30px;
	left: 580px;
	color: green;
	font-family: "隶书";
	font-weight: bold;
	font-size: 24px;
}

.back {
	position: absolute;
	top: 50px;
	right: 20px;
	text-decoration: none;
	color: red;
}

.form {
	position: absolute;
	top: 100px;
	left: 540px;
	color: green;
	font-family: "隶书";
	font-weight: bold;
	font-size: 20px;
}

.sub {
	position: absolute;
	top: 130px;
	left: 130px;
}
</style>
<s:head />
</head>
<body bgcolor="#FFFCCC">
	<%
		Object obj = session.getAttribute("admin");
		if (null == obj) {
			request.getRequestDispatcher("../login.jsp").forward(request,
					response);
		}
	%>
	<div class="wel">
		你好，<%=obj%></div>
	<a href="back" class="logout">退出</a>
	<div class="cen">添加图书信息</div>
	<a href="back1" class="back">返回上一页</a>
	<div class="form">
		<s:form action="addbooksaction" method="post">
			<s:textfield label="图书编号" name="book.id"></s:textfield>
			<s:textfield label="图书名字" name="book.name"></s:textfield>
			<s:textfield label="图书类型" name="book.type"></s:textfield>
			<s:textfield label="图书数量" name="book.strsum"></s:textfield>
			<s:submit value="添加" cssClass="sub"></s:submit>
		</s:form>
	</div>
</body>
</html>