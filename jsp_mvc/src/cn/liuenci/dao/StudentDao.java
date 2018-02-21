package cn.liuenci.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.liuenci.conn.DataManager;
import cn.liuenci.conn.ParamSet;
import cn.liuenci.conn.RowDatas;
import cn.liuenci.entity.StudentEntity;

/**
 * ѧ��Dao��
 * 1. ���ѧ����Ϣ
 * 2. �޸�ѧ����Ϣ
 * 3. ɾ��ѧ����Ϣ
 * 4. ��ҳ��ѯѧ����Ϣ
 * 5. ��ѯѧ����¼��
 * 
 * @author Administrator
 *
 */
public class StudentDao extends DataManager{
	private RowDatas<StudentEntity> student;   //����һ��ѧ���������������
	private RowDatas<Integer> total;  //����һ�����ͽ��
	
	public StudentDao(){
		student = new StudentData();  //ʵ������������
		total = new StudentTotal();  
	}

	/**
	 * 4. ��ҳ��ѯѧ����Ϣ
	 * @return
	 */
	public List<StudentEntity> getStudentByPage(int curr,int pagesize){
		String sql = "select * from tb_student limit ?,?";
		return queryList(sql, new ParamSet(curr,pagesize), student);
	}
	
	/**
	 * 5.��ȡѧ���ܼ�¼��
	 * @return
	 */
	public int getStudentTotal(){
		String sql = "select count(*) from tb_student";
		return query(sql, total);
	}
	
	
	/**
	 * ͨ���ڲ���ʵ�ֽ������ӿ�
	 * @author Administrator
	 *
	 */
	private class StudentData implements RowDatas<StudentEntity>{

		@Override
		public StudentEntity getRowData(ResultSet rs) throws SQLException {
			StudentEntity student = new StudentEntity();
			//��StudentEntity��ֵ
			student.setStuId(rs.getInt(1));
			student.setStuCode(rs.getString(2));
			student.setStuName(rs.getString(3));
			student.setStuSex(rs.getString(4));
			student.setStuPhone(rs.getString(5));
			student.setStuBirthday(rs.getString(6));
			return student;
		}
		
	}
	
	/**
	 * ͨ���ڲ�������������ݴ���
	 * @author Administrator
	 *
	 */
	private class StudentTotal implements RowDatas<Integer>{

		@Override
		public Integer getRowData(ResultSet rs) throws SQLException {
			return rs.getInt(1); 
		}
		
	}
	
}