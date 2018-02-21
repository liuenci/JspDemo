package cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.StudentBean;
import cn.control.student.StudentControl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		//获得地址栏中page和size的值
		String page = request.getParameter("page");
		String size = request.getParameter("size");
 
		//计算当前页数和每页显示数据量
		int currpage = page==null?1:Integer.parseInt(page);
		int pagesize = size==null?5:Integer.parseInt(size);
		
		StudentControl sc = new StudentControl();
		
		//获得学生总数和总页数
		int total = sc.getStudentTotal();
		int pages = ((total-1)/pagesize)+1;
		
		if(currpage<=0) {
			currpage=1;
		}
		if(currpage>pages) {
			currpage = pages;
		}
		
		List<StudentBean> stuList = sc.getStudentByPage(currpage, pagesize);
		
		request.setAttribute("stuList", stuList);
		request.setAttribute("last", currpage-1);
		request.setAttribute("next", currpage+1);
		request.setAttribute("pages", pages);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
