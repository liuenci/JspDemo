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
			//��ʼ��������
			context = new InitialContext();
			//��ȡ����Դ
			dataSource = (DataSource)context.lookup("java:/comp/env/java/shopping");
			//��ȡ���ݿ�����
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
