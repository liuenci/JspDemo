package cn.liuenci.entity;

public class StudentEntity {
	private int stuId;
	private String stuCode;
	private String stuName;
	private String stuSex;
	private String stuPhone;
	private String stuBirthday;
	
	
	public StudentEntity() {
		super();
	}
	public StudentEntity(int stuId, String stuCode, String stuName, String stuSex, String stuPhone,
			String stuBirthday) {
		super();
		this.stuId = stuId;
		this.stuCode = stuCode;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuPhone = stuPhone;
		this.stuBirthday = stuBirthday;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuCode() {
		return stuCode;
	}
	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public String getStuBirthday() {
		return stuBirthday;
	}
	public void setStuBirthday(String stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
	
	
}
