package booksManage.admin;

import java.sql.ResultSet;

import booksManage.Dao.DBServer;
import booksManage.stu.Book;
import booksManage.stu.Student;

import com.opensymphony.xwork2.ActionSupport;

public class BookManage extends ActionSupport {

	private Student stu;
	private Book book;
	private static final long serialVersionUID = 1L;

	/**
	 * 跳转到增加学生信息界面
	 */
	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
	
	/**
	 * 执行添加学生信息
	 */
	public String AddStuAction()throws Exception{
		if("".equals(stu.getNumber())||null==stu.getNumber()){
			this.addFieldError("stu.number","学号不能为空！");
			return INPUT;
		}
		if("".equals(stu.getName())||null==stu.getName()){
			this.addFieldError("stu.name","姓名不能为空！");
			return INPUT;
		}
		if("".equals(stu.getSex())||null==stu.getSex()){
			this.addFieldError("stu.sex","性别不能为空！");
			return INPUT;
		}
		if("".equals(stu.getClasses())||null==stu.getClasses()){
			this.addFieldError("stu.classes","班级不能为空！");
			return INPUT;
		}
		if("".equals(stu.getDept())||null==stu.getDept()){
			this.addFieldError("stu.dept","所属系不能为空！");
			return INPUT;
		}
		DBServer dbs= new DBServer();
		//判断学号是不是重复
		ResultSet rs=dbs.SelectDatabase("student");
		//count为0==没有重复
		int count=0;
		while(rs.next()){
			if(rs.getString("number").equals(stu.getNumber())){
						count++;
			}
		}
		if(count>0){
			this.addFieldError("stu.number","学号重复");
			return INPUT;
		}
		dbs.InsertStuInfo(stu.getNumber(),stu.getName(),stu.getSex(),stu.getClasses(),stu.getDept());
		dbs.close();
		return SUCCESS;
	}
	/**
	 *跳转到添加图书的界面 
	 */
	public String AddBooks()throws Exception{
		
		return SUCCESS;
	}
	/**
	 *执行添加图书 
	 */
	public String AddBooksAction()throws Exception{
		if("".equals(book.getId())||null==book.getId()){
			this.addFieldError("book.id","图书编号不能为空");
			return INPUT;
		}
		if("".equals(book.getName())||null==book.getName()){
			this.addFieldError("book.name","图书名字不能为空");
			return INPUT;
		}
		if("".equals(book.getType())||null==book.getType()){
			this.addFieldError("book.type","图书类型不能为空");
			return INPUT;
		}
		if("".equals(book.getStrsum())||null==book.getStrsum()){
			this.addFieldError("book.strsum","图书数量不能为空");
			return INPUT;
		}
		if(!book.getStrsum().matches("\\d{1,}")){
			this.addFieldError("book.strsum","图书数量只能填整数");
			return INPUT;
		}
		int sum=Integer.parseInt(book.getStrsum());
		DBServer dbs= new DBServer();
		//判断图书编号是不是重复
		ResultSet rs=dbs.SelectDatabase("books");
		//count为0==没有重复
		int count=0;
		while(rs.next()){
			if(rs.getString("id").equals(book.getId())){
				count++;
			}
		}
		if(count>0){
			this.addFieldError("book.id","图书编号重复");
			return INPUT;
		}
		dbs.InsertBooksInfo(book.getId(),book.getName(),book.getType(), sum);
		dbs.close();
		return SUCCESS;
	}
	
	/**
	 *跳转到查询图书界面 
	 */
	public String BackSelect()throws Exception{
		
		return SUCCESS;
	}
	/**
	 *跳转到修改图书图书界面 
	 */
	public String UpdateBook()throws Exception{
		
		return SUCCESS;
	}
	/**
	 * 执行修改图书
	 */
	public String UpdateBookAction()throws Exception{
		if("".equals(book.getId())||null==book.getId()){
			this.addFieldError("book.id","图书编号不能为空");
			return INPUT;
		}
		if("".equals(book.getName())||null==book.getName()){
			this.addFieldError("book.name","图书名字不能为空");
			return INPUT;
		}
		if("".equals(book.getType())||null==book.getType()){
			this.addFieldError("book.type","图书类型不能为空");
			return INPUT;
		}
		if("".equals(book.getStrsum())||null==book.getStrsum()){
			this.addFieldError("book.strsum","图书数量不能为空");
			return INPUT;
		}
		if(!book.getStrsum().matches("\\d{1,}")){
			this.addFieldError("book.strsum","图书数量只能填整数");
			return INPUT;
		}
		int sum=Integer.parseInt(book.getStrsum());
		DBServer dbs= new DBServer();
		//判断图书编号是否存在
		ResultSet rs=dbs.SelectDatabase("books");
		//count为0不存在
		int count=0;
		while(rs.next()){
			if(rs.getString("id").equals(book.getId())){
				count++;
			}
		}
		if(0==count){
			this.addFieldError("book.id","图书编号不存在");
			return INPUT;
		}
		dbs.UpdateBookInfo(book.getId(),book.getName(),book.getType(), sum);
		dbs.close();
		return SUCCESS;
	}
	/**
	 *跳转到删除学生信息界面 
	 */
	public String DeleteStu()throws Exception{
		
		return SUCCESS;
	}
	/**
	 *执行删除学生信息 
	 */
	public String DeleteStuAction()throws Exception{
		if("".equals(stu.getNumber())||null==stu.getNumber()){
			this.addFieldError("stu.number","学号不能为空");
			return INPUT;
		}
		DBServer dbs= new DBServer();
		ResultSet rs=dbs.SelectDatabase("student");
		//count为0表示找不到学号，不能删除
		int count=0;
		while(rs.next()){
			if(rs.getString("number").equals(stu.getNumber())){
				count++;
			}
		}
		if(0==count){
			this.addFieldError("stu.number","学号不存在，不能删除");
			return INPUT;
		}
		dbs.DeleteStu(stu.getNumber());
		dbs.close();
		return SUCCESS;
	}
	
	/**
	 *跳转到删除图书界面 
	 */
	public String DeleteBook()throws Exception{
		
		return SUCCESS;
	}
	/**
	 *执行删除图书 
	 */
	public String DeleteBookAction()throws Exception{
		if("".equals(book.getId())||null==book.getId()){
			this.addFieldError("book.id","图书编号不能为空");
			return INPUT;
		}
		DBServer dbs= new DBServer();
		ResultSet rs=dbs.SelectDatabase("books");
		//count为0表示找不到此图书编号，不能删除
		int count=0;
		while(rs.next()){
			if(rs.getString("id").equals(book.getId())){
				count++;
			}
		}
		if(0==count){
			this.addFieldError("book.id","图书编号不存在，不能删除");
			return INPUT;
		}
		dbs.DeleteBookInfo(book.getId());
		dbs.close();
		return SUCCESS;
	}
	
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
