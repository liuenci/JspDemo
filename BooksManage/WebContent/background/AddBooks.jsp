<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>���ͼ����ҳ</title>
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
	font-family: "����";
	font-size: 24px;
}

.cen {
	position: absolute;
	top: 30px;
	left: 580px;
	color: green;
	font-family: "����";
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
	font-family: "����";
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
		��ã�<%=obj%></div>
	<a href="back" class="logout">�˳�</a>
	<div class="cen">���ͼ����Ϣ</div>
	<a href="back1" class="back">������һҳ</a>
	<div class="form">
		<s:form action="addbooksaction" method="post">
			<s:textfield label="ͼ����" name="book.id"></s:textfield>
			<s:textfield label="ͼ������" name="book.name"></s:textfield>
			<s:textfield label="ͼ������" name="book.type"></s:textfield>
			<s:textfield label="ͼ������" name="book.strsum"></s:textfield>
			<s:submit value="���" cssClass="sub"></s:submit>
		</s:form>
	</div>
</body>
</html>