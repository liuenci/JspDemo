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
//���÷���·��
@WebServlet("/jstl")
public class EL extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����е�get���󽻸�postȥ����
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����������
		req.setCharacterEncoding("utf-8");
		
		//���ñ���
		req.setAttribute("title", "����õı������");
		//��������
		req.setAttribute("content", "java������������õı������");
		
		//��������
		StudentBean bean = new StudentBean("����","��",20);
		req.setAttribute("bean", bean);
		HttpSession session = req.getSession();
		
		//��������
		int[] arr = {1,2,3,4,5};
		req.setAttribute("arr", arr);
		
		//��������
		List list = new ArrayList();
		list.add("����");
		list.add("����");
		list.add("����");
		req.setAttribute("list", list);
		
		
		//����cookie���󱣴�sessionId
		Cookie c = new Cookie("sessionId",session.getId());
		resp.addCookie(c);
		
		
		//����map����
		Map map = new HashMap();
		map.put("1", "�й�");
		map.put("two", "������");
		req.setAttribute("map", map);
		
		//ת��,��ַ����ַ����
		req.getRequestDispatcher("WEB-INF/jstl/jstlTest.jsp?num=9").forward(req, resp);
	}
}
