package cn.liuenci.service;

import java.util.List;

import cn.liuenci.dao.StudentDao;
import cn.liuenci.entity.PagesEntity;
import cn.liuenci.entity.StudentEntity;

public class StudentService {
	private StudentDao studentDao;
	
	public StudentService() {
		studentDao = new StudentDao();
	}
	
	public PagesEntity<StudentEntity> getStudentByPage(int currpage,int pagesize){
		//记录起始记录数
		int cur = (currpage-1)*pagesize;
		//获取分页数据
		List<StudentEntity> data = studentDao.getStudentByPage(cur, pagesize);
		//获取总记录数
		int total = studentDao.getStudentTotal();
		return new PagesEntity<StudentEntity>(currpage, pagesize, total, data);
	}
}
