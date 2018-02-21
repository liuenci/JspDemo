package cn.database.db;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * ���ݿ����ӽӿ�
 * 
 * @author LuckyJavaCi
 *
 */
public interface DataManagerImpl {
	/**
	 * 1.�������ݿ�����
	 */
	public Connection getConnection();
	
	/**
	 * 2.��ɾ�Ĳ�������������
	 */
	public int updateExecuted(String sql);
	
	/**
	 * 3.��ɾ�Ĳ�����������
	 */
	public int updateExecuted(String sql,ParamSetImpl pstm);
	
	/**
	 * 4.��ѯ��������������������һ����¼
	 */
	public Map<String,Object> query(String sql);
	
	/**
	 * 5.��ѯ�������������������ض�����¼
	 */
	public List<Map<String,Object>> queryList(String sql);
	
	/**
	 * 6.�вβ�ѯ������һ����¼
	 */
	public Map<String,Object> query(String sql,ParamSetImpl pstm);
	
	/**
	 * 7.�вβ�ѯ�����ض�����¼
	 */
	public List<Map<String,Object>> queryList(String sql,ParamSetImpl pstm);
	
	
}
