package cn.liuenci.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.liuenci.conn.DataManager;
import cn.liuenci.conn.ParamSet;
import cn.liuenci.conn.RowDatas;
import cn.liuenci.entity.StudentEntity;

/**
 * 学生Dao类
 * 1. 添加学生信息
 * 2. 修改学生信息
 * 3. 删除学生信息
 * 4. 分页查询学生信息
 * 5. 查询学生记录数
 * 
 * @author Administrator
 *
 */
public class StudentDao extends DataManager{
	private RowDatas<StudentEntity> student;   //声明一个学生对象结果处理对象
	private RowDatas<Integer> total;  //声明一个整型结果
	
	public StudentDao(){
		student = new StudentData();  //实例结果处理对象
		total = new StudentTotal();  
	}

	/**
	 * 4. 分页查询学生信息
	 * @return
	 */
	public List<StudentEntity> getStudentByPage(int curr,int pagesize){
		String sql = "select * from tb_student limit ?,?";
		return queryList(sql, new ParamSet(curr,pagesize), student);
	}
	
	/**
	 * 5.获取学生总记录数
	 * @return
	 */
	public int getStudentTotal(){
		String sql = "select count(*) from tb_student";
		return query(sql, total);
	}
	
	
	/**
	 * 通过内部类实现结果处理接口
	 * @author Administrator
	 *
	 */
	private class StudentData implements RowDatas<StudentEntity>{

		@Override
		public StudentEntity getRowData(ResultSet rs) throws SQLException {
			StudentEntity student = new StudentEntity();
			//给StudentEntity赋值
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
	 * 通过内部类完成整型数据处理
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