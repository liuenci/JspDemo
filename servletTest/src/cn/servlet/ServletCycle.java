package cn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("servletCycle")
public class ServletCycle extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("��ʼ��");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("����get����");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("����post����");
	}
	
	@Override
	public void destroy() {
		System.out.println("������������");
	}
	public static void main(String[] args) {
		new ServletCycle();
	}

}
