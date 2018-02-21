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
// ����·��
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
		// �����е�get���󽻸�postȥ����
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������
		request.setCharacterEncoding("utf-8");

		// ���ñ���
		request.setAttribute("title", "����õı������");
		// ��������
		request.setAttribute("content", "java������������õı������");

		// ��������
		StudentBean bean = new StudentBean("����", "��", 20);
		request.setAttribute("bean", bean);
		HttpSession session = request.getSession();

		// ��������
		int[] arr = { 1, 2, 3, 4, 5 };
		request.setAttribute("arr", arr);

		// ��������
		List list = new ArrayList();
		list.add("����");
		list.add("����");
		list.add("����");
		request.setAttribute("list", list);

		// ����cookie���󱣴�sessionId
		Cookie c = new Cookie("sessionId", session.getId());
		response.addCookie(c);

		// ����map����
		Map map = new HashMap();
		map.put("1", "�й�");
		map.put("two", "������");
		request.setAttribute("map", map);

		//�����ַ�����
		String[] array = {"����һ��","���϶���","��������","�����ĺ�","�������"};
		request.setAttribute("array", array);
		
		// ת��,��ַ����ַ����
		request.getRequestDispatcher("WEB-INF/jstl/jstlTest.jsp").forward(request, response);
		//request.getRequestDispatcher("test.jsp").forward(request, response);
		//response.sendRedirect("test.jsp");
	}

}
