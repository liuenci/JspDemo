package cn.bean;

public class StudentBean {
	private Integer stu_id;
	private String stu_name;
	private Integer stu_sex;
	private Integer stu_age;
	
	public StudentBean() {
		
	}
	public StudentBean(Integer stu_id, String stu_name, Integer stu_sex, Integer stu_age) {
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_age = stu_age;
	}
	public Integer getStu_id() {
		return stu_id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public Integer getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(Integer stu_sex) {
		this.stu_sex = stu_sex;
	}
	public Integer getStu_age() {
		return stu_age;
	}
	public void setStu_age(Integer stu_age) {
		this.stu_age = stu_age;
	}
	
	
	
	
}
