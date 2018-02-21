package cn.liuenci;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bean.StudentBean;
//设置访问路径
@WebServlet("/jstl")
public class EL extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//将所有的get请求交给post去处理
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		
		//设置标题
		req.setAttribute("title", "最好用的编程语言");
		//设置内容
		req.setAttribute("content", "java是世界上最好用的编程语言");
		
		//创建对象
		StudentBean bean = new StudentBean("张三","男",20);
		req.setAttribute("bean", bean);
		HttpSession session = req.getSession();
		
		//创建数组
		int[] arr = {1,2,3,4,5};
		req.setAttribute("arr", arr);
		
		//创建集合
		List list = new ArrayList();
		list.add("李四");
		list.add("王五");
		list.add("马六");
		req.setAttribute("list", list);
		
		
		//创建cookie对象保存sessionId
		Cookie c = new Cookie("sessionId",session.getId());
		resp.addCookie(c);
		
		
		//创建map集合
		Map map = new HashMap();
		map.put("1", "中国");
		map.put("two", "美利坚");
		req.setAttribute("map", map);
		
		//转发,地址栏地址不变
		req.getRequestDispatcher("WEB-INF/jstl/jstlTest.jsp?num=9").forward(req, resp);
	}
}
