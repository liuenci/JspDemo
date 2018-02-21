package cn.conn;

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
 * Servlet implementation class Test_jdbc
 */
@WebServlet("/Test_jdbc")
public class Test_jdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test_jdbc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		try {
			//初始化上下文
			Context context = new InitialContext();
			//获得数据源
			DataSource dataSource = (DataSource)context.lookup("java:/comp/env/jdbc/test");
			//创建连接对象
			Connection conn = dataSource.getConnection();
			//读取数据库
			String sql = "select * from tb_stu";
			PreparedStatement ps = conn.prepareStatement(sql);
			//获取数据结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				out.println(rs.getObject(1)+" "+rs.getObject(2)+" "+rs.getObject(3)+"<br>");
			}
			//关闭连接
			rs.close();
			ps.close();
			conn.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
