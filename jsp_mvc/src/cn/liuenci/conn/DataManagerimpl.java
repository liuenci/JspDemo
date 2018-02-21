package cn.liuenci.conn;
/**
 * 数据库连接接口
 * 1.创建数据库连接 createConnection
 * 2. 添删改操作，不带参数  updateExecuted(String sql)
 * 3. 添删改操作，带参数
 * 4. 无参查询,返回一条记录
 * 5. 有参查询，返回一条记录
 * 6. 无参查询，返回多条记录
 * 7. 有参查询，返回多条记录
 * 
 * @author Administrator
 *
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DataManagerimpl {

	/**
	 * 1.创建数据库连接
	 * @return 
	 */
	Connection createConnection() throws SQLException;
	
	/**
	 * 2. 添删改操作，不带参数
	 * @param sql
	 * @return
	 */
	int updateExecuted(String sql);
	
	/**
	 * 3. 添删改操作，带参数
	 * @param sql
	 * @param objects
	 * @return
	 */
	int updateExecuted(String sql,ParamSetimpl  params);
	
	/**
	 * 4. 无参查询,返回一条记录
	 * @param sql
	 * @return
	 */
	<T> T query(String sql,RowDatas<T> rowDatas);
	
	/**
	 * 5. 有参查询，返回一条记录
	 * @param sql
	 * @param objects
	 * @return
	 */
	<T> T query(String sql,ParamSetimpl  params,RowDatas<T> rowDatas);
	
	/**
	 * 6. 无参查询，返回多条记录
	 * @param sql
	 * @return
	 */
	<T> List<T> queryList(String sql,RowDatas<T> rowDatas);
	
	/**
	 * 7. 有参查询，返回多条记录
	 * @param sql
	 * @param objects
	 * @return
	 */
	<T> List<T> queryList(String sql,ParamSetimpl  params,RowDatas<T> rowDatas);
	
}
