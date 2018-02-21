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
import javax.servlet.jsp.PageContext;

import cn.bean.StudentBean;

/**
 * Servlet implementation class EL
 */
// 访问路径
@WebServlet("/EL")
public class EL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 将所有的get请求交给post去处理
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求编码
		request.setCharacterEncoding("utf-8");

		// 设置标题
		request.setAttribute("title", "最好用的编程语言");
		// 设置内容
		request.setAttribute("content", "java是世界上最好用的编程语言");

		// 创建对象
		StudentBean bean = new StudentBean("张三", "男", 20);
		request.setAttribute("bean", bean);
		HttpSession session = request.getSession();

		// 创建数组
		int[] arr = { 1, 2, 3, 4, 5 };
		request.setAttribute("arr", arr);

		// 创建集合
		List list = new ArrayList();
		list.add("李四");
		list.add("王五");
		list.add("马六");
		request.setAttribute("list", list);

		// 创建cookie对象保存sessionId
		Cookie c = new Cookie("sessionId", session.getId());
		response.addCookie(c);

		// 创建map集合
		Map map = new HashMap();
		map.put("1", "中国");
		map.put("two", "美利坚");
		request.setAttribute("map", map);

		//创建字符数组
		String[] array = {"南南一号","南南二号","南南三号","南南四号","南南五号"};
		request.setAttribute("array", array);
		
		// 转发,地址栏地址不变
		request.getRequestDispatcher("WEB-INF/jstl/jstlTest.jsp").forward(request, response);
		//request.getRequestDispatcher("test.jsp").forward(request, response);
		//response.sendRedirect("test.jsp");
	}

}
