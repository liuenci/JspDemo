package cn.database.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * sql参数实现类
 * @author LuckyJavaCi
 *
 */
public class ParamSet implements ParamSetImpl{

	private Object[] param;
	
	public ParamSet(Object... objects) {
		this.param = objects;
	}
	@Override
	public void setParams(PreparedStatement pstm) {
		//通过循环设置参数
		for(int i=0;i<param.length;i++) {
			try {
				pstm.setObject((i+1), param[i]);
			} catch (SQLException e) {
				System.out.println("参数设置失败。");
			}
		}
	}

}
