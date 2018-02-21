package booksManage.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilCon {
	private Connection con=null;
	
	public UtilCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/library";
		String user="root";
		String password="mysql";
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConn(){
		return con;
	}
}
