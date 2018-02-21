package cn.liuenci.conn;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 查询结果处理接口
 * @author Administrator
 *
 * @param <T>
 */
public interface RowDatas<T> {
	public T getRowData(ResultSet rs) throws SQLException;
}
