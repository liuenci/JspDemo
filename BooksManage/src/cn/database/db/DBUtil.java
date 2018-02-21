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
	// 数据库连接路径
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xscj";
	// 用户名
	private static final String USER = "root";
	// 密码
	private static final String PASSWORD = "JavaL0318";
	//数据库连接对象
	private static Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public DBUtil() {
		//加载驱动程序
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			
		}
	}
	public static void main(String[] args) {
		new DBUtil().getConnection();
	}

	@Override
	public Connection getConnection() {
		//如果连接对象为空或者连接对象被关闭，就调用创建连接方法
		try {
			if(conn==null||conn.isClosed()) {
				//连接数据库
				conn = DriverManager.getConnection(URL,USER,PASSWORD);
			}
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
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
			//执行sql语句
			ps = getConnection().prepareStatement(sql);
			//设置参数
			if(params!=null) {
				//调用参数设置方法
				params.setParams(ps);
			}
			row = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("预处理sql语句失败");
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
			//获取sql执行对象
			ps = getConnection().prepareStatement(sql);
			if(pstm!=null) {
				//调用参数处理方法
				pstm.setParams(ps);
			}
			rs = ps.executeQuery();
			//获取数据表字段集合
			ResultSetMetaData rsmt = rs.getMetaData();
			
			//处理结果集
			while(rs.next()) {
				data = this.getResult(rsmt, rs);
			}
		} catch (SQLException e) {
			System.out.println("预处理sql语句失败。");
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
			//预处理sql语句
			ps = getConnection().prepareStatement(sql);
			//设置参数
			if(pstm!=null) {
				//调用参数设置方法
				pstm.setParams(ps);
			}
			rs = ps.executeQuery();
			//获取数据表字段集合
			ResultSetMetaData rsmt = rs.getMetaData();
			//处理结果集
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
	 * 将结果集的数据存放到map集合中
	 */
	private Map<String,Object> getResult(ResultSetMetaData rsmt,ResultSet rs2){
		Map<String,Object> map = new HashMap<String,Object>();
		//找到对应字段名和值
		try {
			for(int i =1;i<rsmt.getColumnCount();i++) {
				//找到列名
				String colname = rsmt.getColumnName(i);
				//找到列对应的值
				Object colvalue = rs.getObject(colname);
				if(colvalue==null) {
					colvalue = "";
				}
				//将字段和值添加到map集合map.put
				map.put(colname, colvalue);
			}
		} catch (SQLException e) {
			System.out.println("数据存放失败。");
		}
		return map;
	}
}
