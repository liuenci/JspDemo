package cn.liuenci.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.liuenci.entity.PagesEntity;
import cn.liuenci.entity.StudentEntity;
import cn.liuenci.service.StudentService;

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
		// �����������
		request.setCharacterEncoding("UTF-8");
		// �����������
		String page = request.getParameter("page").trim();
		String size = request.getParameter("size").trim();

		int currpage = (page == null) ? 1 : Integer.parseInt(page.trim());
		int pagesize = (size == null) ? 5 : Integer.parseInt(size.trim());

		// ��ȡ��ҳ��Ϣ
		StudentService stu = new StudentService();
		PagesEntity<StudentEntity> pages = stu.getStudentByPage(currpage, pagesize);
		request.setAttribute("pages", pages);

		// ת��
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
