package cn.dao.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.bean.StudentBean;
import cn.database.DataManager;
import cn.database.ParamSet;
import cn.database.RowDatas;

public class StudentDao extends DataManager {
	private RowDatas<StudentBean> student;
	private RowDatas<Integer> total;

	public StudentDao() {
		student = new StudentData();
		total = new StudentTotal();
	}

	/*
	 * �������ѧ������
	 */
	public List<StudentBean> getStudentAll() {
		String sql = "select * from tb_stu";
		return queryList(sql, student);
	}

	/*
	 * ���ѧ������
	 */
	public int getStudentTotal() {
		String sql = "select count(*) from tb_stu";
		return query(sql, total);
	}

	/*
	 * ��ҳ���ѧ��
	 * currpage:��ǰҳ
	 * pagesize:һ����ҳ��ʾ������
	 */
	public List<StudentBean> getStudentByPage(int currpage, int pagesize) {
		//�ڼ�ҳ�������Ǵ�0��ʼ���������ݿ��Ǵ�1��ʼ���㣬������Ҫ��ȥһ
		int cur = (currpage - 1) * pagesize;
		String sql = "select * from tb_stu limit ?,?";
		return queryList(sql, new ParamSet(cur, pagesize), student);
	}

	// ʵ�ֻ�ȡ����Դ�ӿ�
	private class StudentData implements RowDatas<StudentBean> {

		@Override
		public StudentBean getRowData(ResultSet rs) throws SQLException {
			StudentBean sb = new StudentBean();
			sb.setStu_id(rs.getInt(1));
			sb.setStu_name(rs.getString(2));
			sb.setStu_sex(rs.getInt(3));
			sb.setStu_age(rs.getInt(4));
			return sb;
		}

	}

	private class StudentTotal implements RowDatas<Integer> {

		@Override
		public Integer getRowData(ResultSet rs) throws SQLException {
			return rs.getInt(1);
		}

	}

}
