package cn.database.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil implements DataManagerImpl {
	// ���ݿ�����·��
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xscj";
	// �û���
	private static final String USER = "root";
	// ����
	private static final String PASSWORD = "JavaL0318";
	//���ݿ����Ӷ���
	private static Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public DBUtil() {
		//������������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ��");
			
		}
	}
	public static void main(String[] args) {
		new DBUtil().getConnection();
	}

	@Override
	public Connection getConnection() {
		//������Ӷ���Ϊ�ջ������Ӷ��󱻹رգ��͵��ô������ӷ���
		try {
			if(conn==null||conn.isClosed()) {
				//�������ݿ�
				conn = DriverManager.getConnection(URL,USER,PASSWORD);
			}
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public int updateExecuted(String sql) {
		return this.updateExecuted(sql,null);
	}

	@Override
	public int updateExecuted(String sql, ParamSetImpl params) {
		int row = 0;
		try {
			//ִ��sql���
			ps = getConnection().prepareStatement(sql);
			//���ò���
			if(params!=null) {
				//���ò������÷���
				params.setParams(ps);
			}
			row = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Ԥ����sql���ʧ��");
			e.printStackTrace();
		} finally {
			this.close();
		}
		return row;
	}

	@Override
	public Map<String, Object> query(String sql) {
		return this.query(sql, null);
	}

	@Override
	public List<Map<String, Object>> queryList(String sql) {
		
		return this.queryList(sql, null);
	}

	@Override
	public Map<String, Object> query(String sql, ParamSetImpl pstm) {
		Map<String,Object> data = new HashMap<String,Object>();
		try {
			//��ȡsqlִ�ж���
			ps = getConnection().prepareStatement(sql);
			if(pstm!=null) {
				//���ò���������
				pstm.setParams(ps);
			}
			rs = ps.executeQuery();
			//��ȡ���ݱ��ֶμ���
			ResultSetMetaData rsmt = rs.getMetaData();
			
			//��������
			while(rs.next()) {
				data = this.getResult(rsmt, rs);
			}
		} catch (SQLException e) {
			System.out.println("Ԥ����sql���ʧ�ܡ�");
			e.printStackTrace();
		}finally {
			this.close();
		}
		return data;
	}

	public void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public List<Map<String, Object>> queryList(String sql, ParamSetImpl pstm) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			//Ԥ����sql���
			ps = getConnection().prepareStatement(sql);
			//���ò���
			if(pstm!=null) {
				//���ò������÷���
				pstm.setParams(ps);
			}
			rs = ps.executeQuery();
			//��ȡ���ݱ��ֶμ���
			ResultSetMetaData rsmt = rs.getMetaData();
			//��������
			while(rs.next()) {
				Map<String,Object> map = this.getResult(rsmt, rs);
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * ������������ݴ�ŵ�map������
	 */
	private Map<String,Object> getResult(ResultSetMetaData rsmt,ResultSet rs2){
		Map<String,Object> map = new HashMap<String,Object>();
		//�ҵ���Ӧ�ֶ�����ֵ
		try {
			for(int i =1;i<rsmt.getColumnCount();i++) {
				//�ҵ�����
				String colname = rsmt.getColumnName(i);
				//�ҵ��ж�Ӧ��ֵ
				Object colvalue = rs.getObject(colname);
				if(colvalue==null) {
					colvalue = "";
				}
				//���ֶκ�ֵ��ӵ�map����map.put
				map.put(colname, colvalue);
			}
		} catch (SQLException e) {
			System.out.println("���ݴ��ʧ�ܡ�");
		}
		return map;
	}
}
