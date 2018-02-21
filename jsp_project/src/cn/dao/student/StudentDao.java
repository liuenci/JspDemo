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
	 * 获得所有学生对象
	 */
	public List<StudentBean> getStudentAll() {
		String sql = "select * from tb_stu";
		return queryList(sql, student);
	}

	/*
	 * 获得学生总数
	 */
	public int getStudentTotal() {
		String sql = "select count(*) from tb_stu";
		return query(sql, total);
	}

	/*
	 * 分页获得学生
	 * currpage:当前页
	 * pagesize:一个分页显示的数量
	 */
	public List<StudentBean> getStudentByPage(int currpage, int pagesize) {
		//第几页，数据是从0开始，但是数据库是从1开始计算，所以需要减去一
		int cur = (currpage - 1) * pagesize;
		String sql = "select * from tb_stu limit ?,?";
		return queryList(sql, new ParamSet(cur, pagesize), student);
	}

	// 实现获取数据源接口
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
