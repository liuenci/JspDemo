<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��̨ͼ�����</title>
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
.cen{
position: absolute;
top: 35px;
left: 580px;
color: green;
font-weight: bold;
}
.addstu{
position: absolute;
top: 60px;
left: 40px;
text-align: center;
color: red;
text-decoration: none;
font-weight: bold;
}
.addbook{
position: absolute;
top: 60px;
left: 480px;
text-align: center;
color: red;
text-decoration: none;
font-weight: bold;
}
.select{
position: absolute;
top: 60px;
right: 40px;
text-align: center;
color: red;
text-decoration: none;
font-weight: bold;
}
.update{
position: absolute;
top: 350px;
left: 40px;
text-align: center;
color: red;
text-decoration: none;
font-weight: bold;
}
.deletestu{
position: absolute;
top: 350px;
left: 480px;
text-align: center;
color: red;
text-decoration: none;
font-weight: bold;
}
.deletebook{
position: absolute;
top: 350px;
right: 40px;
text-align: center;
color: red;
text-decoration: none;
font-weight: bold;
}
</style>
</head>
<body bgcolor="#FFFCCC">
<%
	Object obj=session.getAttribute("admin");
	if(null==obj){
		request.getRequestDispatcher("../login.jsp").forward(request,response);
	}
%>
<div class="wel">��ã�<%=obj %></div>
<a href="back" class="back">�˳�</a>
<center class="cen">ͼ�������ҳ</center>
<a href="addstu" class="addstu" target="_blank"><img src="pics/addstu.jpg" style="border: 0px;"><br/>���ѧ����Ϣ</a>
<a href="addbook" class="addbook" target="_blank"><img src="pics/addbook.jpg" style="border: 0px;"><br/>���ͼ����Ϣ</a>
<a href="backgroundselect" class="select" target="_blank"><img src="pics/select.jpg" style="border: 0px;"><br/>��ѯͼ��</a>
<a href="updatebook" class="update" target="_blank"><img src="pics/update.jpg" style="border: 0px;"><br/>�޸�ͼ����Ϣ</a>
<a href="deletestu" class="deletestu" target="_blank"><img src="pics/deletestu.jpg" style="border: 0px;"><br/>ɾ��ѧ����Ϣ</a>
<a href="deletebook" class="deletebook" target="_blank"><img src="pics/deletebook.jpg" style="border: 0px;"><br/>ɾ��ͼ����Ϣ</a>
</body>
</html>