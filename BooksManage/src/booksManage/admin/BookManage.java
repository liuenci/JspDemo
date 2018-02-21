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
	 * ��ת������ѧ����Ϣ����
	 */
	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
	
	/**
	 * ִ�����ѧ����Ϣ
	 */
	public String AddStuAction()throws Exception{
		if("".equals(stu.getNumber())||null==stu.getNumber()){
			this.addFieldError("stu.number","ѧ�Ų���Ϊ�գ�");
			return INPUT;
		}
		if("".equals(stu.getName())||null==stu.getName()){
			this.addFieldError("stu.name","��������Ϊ�գ�");
			return INPUT;
		}
		if("".equals(stu.getSex())||null==stu.getSex()){
			this.addFieldError("stu.sex","�Ա���Ϊ�գ�");
			return INPUT;
		}
		if("".equals(stu.getClasses())||null==stu.getClasses()){
			this.addFieldError("stu.classes","�༶����Ϊ�գ�");
			return INPUT;
		}
		if("".equals(stu.getDept())||null==stu.getDept()){
			this.addFieldError("stu.dept","����ϵ����Ϊ�գ�");
			return INPUT;
		}
		DBServer dbs= new DBServer();
		//�ж�ѧ���ǲ����ظ�
		ResultSet rs=dbs.SelectDatabase("student");
		//countΪ0==û���ظ�
		int count=0;
		while(rs.next()){
			if(rs.getString("number").equals(stu.getNumber())){
						count++;
			}
		}
		if(count>0){
			this.addFieldError("stu.number","ѧ���ظ�");
			return INPUT;
		}
		dbs.InsertStuInfo(stu.getNumber(),stu.getName(),stu.getSex(),stu.getClasses(),stu.getDept());
		dbs.close();
		return SUCCESS;
	}
	/**
	 *��ת�����ͼ��Ľ��� 
	 */
	public String AddBooks()throws Exception{
		
		return SUCCESS;
	}
	/**
	 *ִ�����ͼ�� 
	 */
	public String AddBooksAction()throws Exception{
		if("".equals(book.getId())||null==book.getId()){
			this.addFieldError("book.id","ͼ���Ų���Ϊ��");
			return INPUT;
		}
		if("".equals(book.getName())||null==book.getName()){
			this.addFieldError("book.name","ͼ�����ֲ���Ϊ��");
			return INPUT;
		}
		if("".equals(book.getType())||null==book.getType()){
			this.addFieldError("book.type","ͼ�����Ͳ���Ϊ��");
			return INPUT;
		}
		if("".equals(book.getStrsum())||null==book.getStrsum()){
			this.addFieldError("book.strsum","ͼ����������Ϊ��");
			return INPUT;
		}
		if(!book.getStrsum().matches("\\d{1,}")){
			this.addFieldError("book.strsum","ͼ������ֻ��������");
			return INPUT;
		}
		int sum=Integer.parseInt(book.getStrsum());
		DBServer dbs= new DBServer();
		//�ж�ͼ�����ǲ����ظ�
		ResultSet rs=dbs.SelectDatabase("books");
		//countΪ0==û���ظ�
		int count=0;
		while(rs.next()){
			if(rs.getString("id").equals(book.getId())){
				count++;
			}
		}
		if(count>0){
			this.addFieldError("book.id","ͼ�����ظ�");
			return INPUT;
		}
		dbs.InsertBooksInfo(book.getId(),book.getName(),book.getType(), sum);
		dbs.close();
		return SUCCESS;
	}
	
	/**
	 *��ת����ѯͼ����� 
	 */
	public String BackSelect()throws Exception{
		
		return SUCCESS;
	}
	/**
	 *��ת���޸�ͼ��ͼ����� 
	 */
	public String UpdateBook()throws Exception{
		
		return SUCCESS;
	}
	/**
	 * ִ���޸�ͼ��
	 */
	public String UpdateBookAction()throws Exception{
		if("".equals(book.getId())||null==book.getId()){
			this.addFieldError("book.id","ͼ���Ų���Ϊ��");
			return INPUT;
		}
		if("".equals(book.getName())||null==book.getName()){
			this.addFieldError("book.name","ͼ�����ֲ���Ϊ��");
			return INPUT;
		}
		if("".equals(book.getType())||null==book.getType()){
			this.addFieldError("book.type","ͼ�����Ͳ���Ϊ��");
			return INPUT;
		}
		if("".equals(book.getStrsum())||null==book.getStrsum()){
			this.addFieldError("book.strsum","ͼ����������Ϊ��");
			return INPUT;
		}
		if(!book.getStrsum().matches("\\d{1,}")){
			this.addFieldError("book.strsum","ͼ������ֻ��������");
			return INPUT;
		}
		int sum=Integer.parseInt(book.getStrsum());
		DBServer dbs= new DBServer();
		//�ж�ͼ�����Ƿ����
		ResultSet rs=dbs.SelectDatabase("books");
		//countΪ0������
		int count=0;
		while(rs.next()){
			if(rs.getString("id").equals(book.getId())){
				count++;
			}
		}
		if(0==count){
			this.addFieldError("book.id","ͼ���Ų�����");
			return INPUT;
		}
		dbs.UpdateBookInfo(book.getId(),book.getName(),book.getType(), sum);
		dbs.close();
		return SUCCESS;
	}
	/**
	 *��ת��ɾ��ѧ����Ϣ���� 
	 */
	public String DeleteStu()throws Exception{
		
		return SUCCESS;
	}
	/**
	 *ִ��ɾ��ѧ����Ϣ 
	 */
	public String DeleteStuAction()throws Exception{
		if("".equals(stu.getNumber())||null==stu.getNumber()){
			this.addFieldError("stu.number","ѧ�Ų���Ϊ��");
			return INPUT;
		}
		DBServer dbs= new DBServer();
		ResultSet rs=dbs.SelectDatabase("student");
		//countΪ0��ʾ�Ҳ���ѧ�ţ�����ɾ��
		int count=0;
		while(rs.next()){
			if(rs.getString("number").equals(stu.getNumber())){
				count++;
			}
		}
		if(0==count){
			this.addFieldError("stu.number","ѧ�Ų����ڣ�����ɾ��");
			return INPUT;
		}
		dbs.DeleteStu(stu.getNumber());
		dbs.close();
		return SUCCESS;
	}
	
	/**
	 *��ת��ɾ��ͼ����� 
	 */
	public String DeleteBook()throws Exception{
		
		return SUCCESS;
	}
	/**
	 *ִ��ɾ��ͼ�� 
	 */
	public String DeleteBookAction()throws Exception{
		if("".equals(book.getId())||null==book.getId()){
			this.addFieldError("book.id","ͼ���Ų���Ϊ��");
			return INPUT;
		}
		DBServer dbs= new DBServer();
		ResultSet rs=dbs.SelectDatabase("books");
		//countΪ0��ʾ�Ҳ�����ͼ���ţ�����ɾ��
		int count=0;
		while(rs.next()){
			if(rs.getString("id").equals(book.getId())){
				count++;
			}
		}
		if(0==count){
			this.addFieldError("book.id","ͼ���Ų����ڣ�����ɾ��");
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
