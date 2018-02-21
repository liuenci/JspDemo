package cn.database.db;

import java.sql.PreparedStatement;

/**
 * 参数设置接口
 * @author LuckyJavaCi
 *
 */
public interface ParamSetImpl {
	public void setParams(PreparedStatement pstm);
}
