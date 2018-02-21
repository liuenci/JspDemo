package cn.database.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * sql����ʵ����
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
		//ͨ��ѭ�����ò���
		for(int i=0;i<param.length;i++) {
			try {
				pstm.setObject((i+1), param[i]);
			} catch (SQLException e) {
				System.out.println("��������ʧ�ܡ�");
			}
		}
	}

}
