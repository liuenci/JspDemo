package cn.liuenci.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/Conn")
public class ConnectionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnectionTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			// 初始化环境
			Context ctx = new InitialContext();
			// 获取数据源
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/shopping");
			// 获取连接对象
			Connection conn = ds.getConnection();
			// 读取数据
			String sql = "select * from items";
			PreparedStatement ps = conn.prepareStatement(sql);
			//获取数据结果集
			ResultSet rs = ps.executeQuery();
			PrintWriter out = response.getWriter();
			while(rs.next()) {
				out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3));
				out.println("<hr>");
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
