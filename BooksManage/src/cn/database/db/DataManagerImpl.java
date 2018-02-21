package cn.database.db;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * 数据库连接接口
 * 
 * @author LuckyJavaCi
 *
 */
public interface DataManagerImpl {
	/**
	 * 1.创建数据库连接
	 */
	public Connection getConnection();
	
	/**
	 * 2.增删改操作，不带参数
	 */
	public int updateExecuted(String sql);
	
	/**
	 * 3.增删改操作，带参数
	 */
	public int updateExecuted(String sql,ParamSetImpl pstm);
	
	/**
	 * 4.查询操作，不带参数，返回一条记录
	 */
	public Map<String,Object> query(String sql);
	
	/**
	 * 5.查询操作，不带参数，返回多条记录
	 */
	public List<Map<String,Object>> queryList(String sql);
	
	/**
	 * 6.有参查询，返回一条记录
	 */
	public Map<String,Object> query(String sql,ParamSetImpl pstm);
	
	/**
	 * 7.有参查询，返回多条记录
	 */
	public List<Map<String,Object>> queryList(String sql,ParamSetImpl pstm);
	
	
}
