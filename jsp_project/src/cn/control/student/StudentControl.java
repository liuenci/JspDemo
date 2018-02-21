package cn.control.student;

import java.util.List;

import cn.bean.StudentBean;
import cn.dao.student.StudentDao;

public class StudentControl {
	private StudentDao studentDao;
	
	public StudentControl() {
		studentDao = new StudentDao();
	}
	
	public List<StudentBean> getStudentAll(){
		return studentDao.getStudentAll();
	}
	
	public List<StudentBean> getStudentByPage(int currpage,int pagesize){
		return studentDao.getStudentByPage(currpage, pagesize);
	}
	
	public int getStudentTotal() {
		return studentDao.getStudentTotal();
	}
}
