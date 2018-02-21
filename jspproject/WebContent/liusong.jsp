<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
			//创建cookie对象
			response.setContentType("text/html;charset=UTF-8");
			Cookie cook=new Cookie("name", URLEncoder.encode("刘松"));
			Cookie cook1=new Cookie(URLEncoder.encode("age","utf-8"),"18");
			Cookie cook2=new Cookie("date","1997-09-02");
			Cookie cook3=new Cookie("tel","15073376772");
			cook.setMaxAge(24*2400);
			cook1.setMaxAge(24*2400);
			cook2.setMaxAge(24*2400);
			cook3.setMaxAge(24*2400);
			
			response.addCookie(cook);
			response.addCookie(cook1);
			response.addCookie(cook2);
			response.addCookie(cook3);
			
			Cookie[] cooks=request.getCookies();
			if(cooks==null){
				out.print("暂时还未有信息");
			}
			else{
				for(int i=0;i<cooks.length;i++){
					out.print(URLDecoder.decode(cooks[i].getName(), "UTF-8")+":"+URLDecoder.decode(cooks[i].getValue()));
				}
			}
			
		%>
</body>
</html>