package cn.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.UserFormBean;
import cn.util.WEBUtil;
@WebServlet("/UserServlet")
@MultipartConfig
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserFormBean userFormBean = new UserFormBean();
		String address = URLEncoder.encode(req.getParameter("address"), "UTF-8");
//		userFormBean.setAddress(address);
		
		String userName = URLEncoder.encode(req.getParameter("userName"),"UTF-8") ;
//		userFormBean.setUserName(userName);
		
		String email = URLEncoder.encode(req.getParameter("email"),"UTF-8") ;
//		userFormBean.setEmail(email);
		
		int userAge = Integer.parseInt(URLEncoder.encode(req.getParameter("userAge"),"utf-8"));
//		userFormBean.setUserAge(userAge);
		
		String birthday = URLEncoder.encode(req.getParameter("birthday"), "utf-8");
//		userFormBean.setBirthday(birthday);
		
		WEBUtil webUtil = new WEBUtil(address, userName, email, userAge, birthday);
	}
}
