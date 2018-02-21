package cn.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	Context context = null;
	DataSource dataSource = null;
	public DBUtil() {
		
		try {
			//初始化上下文
			context = new InitialContext();
			//获取数据源
			dataSource = (DataSource)context.lookup("java:/comp/env/java/shopping");
			//获取数据库连接
			Connection conn = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public static void main(String[] args) {

	}

}
