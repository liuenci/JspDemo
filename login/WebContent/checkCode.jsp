<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//设置页面格式为图片
		response.setContentType("image/png");
		//创建图片对象
		BufferedImage bi = new BufferedImage(130,60,BufferedImage.TYPE_3BYTE_BGR);
		//获取图片上下文对象
		Graphics g = bi.getGraphics();
		//设置椭圆边框
		//g.drawOval(0,0,130,50);
		//生成随机数
		String num = "";
		for(int i=0;i<4;i++){
			char a = (char)Math.floor(Math.random()*26+65);
			num+=a+" ";
		}
		//设置图片背景颜色
		g.setColor(Color.yellow);
		//设置填充矩形边框
		g.fillRect(0,0,130,60);
		//设置矩形边框颜色
		g.setColor(Color.red);
		g.drawRect(0, 0, 128, 58);
		//设置字体颜色
		g.setColor(Color.red);
		g.setFont(new Font("隶书",Font.ITALIC,18));
		g.drawString(num, 30, 30);
		//将图片写入outputStream流
		ImageIO.write(bi,"png",response.getOutputStream());
		g.dispose();
		out.clear();
		out = pageContext.pushBody();
		
	%>
</body>
</html>