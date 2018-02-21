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
		//��¼��ʼ��¼��
		int cur = (currpage-1)*pagesize;
		//��ȡ��ҳ����
		List<StudentEntity> data = studentDao.getStudentByPage(cur, pagesize);
		//��ȡ�ܼ�¼��
		int total = studentDao.getStudentTotal();
		return new PagesEntity<StudentEntity>(currpage, pagesize, total, data);
	}
}
