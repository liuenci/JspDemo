package cn.liuenci.conn;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��ѯ�������ӿ�
 * @author Administrator
 *
 * @param <T>
 */
public interface RowDatas<T> {
	public T getRowData(ResultSet rs) throws SQLException;
}
