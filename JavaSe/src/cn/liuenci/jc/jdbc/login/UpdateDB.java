package cn.liuenci.jc.jdbc.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDB {
	public static void updateDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsgc","root","123456");
			Statement stat = con.createStatement();
			String sql = "update employee set password = '123456' where sex = 'Ů'";
			stat.executeUpdate(sql);
			stat.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UpdateDB.updateDB();
	}
	

}
