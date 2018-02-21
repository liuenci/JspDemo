package booksManage.stu;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import booksManage.Dao.DBServer;

import com.opensymphony.xwork2.ActionSupport;

public class PersonalManage extends ActionSupport{
	private static final long serialVersionUID = 1L;

	
	private String content;
	private String type;
	
	/**
	 * ��֤��½
	 */
	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		HttpSession session=request.getSession();
		DBServer dbs= new DBServer();
		ResultSet rs=dbs.SelectDatabase("student");
		while(rs.next()){
			String db_number=rs.getString("number");
			String db_name=rs.getString("name");
			if(db_number.equals(number)&&db_name.equals(name)){
				session.setAttribute("userName",name);
				session.setAttribute("number",number);
				return SUCCESS;
			}
		}
		return "error";
	}
	/**
	 * ���ص���ҳ
	 */
	public String StudentBack()throws Exception{
		
		return SUCCESS;
	}
	/**
	 * ��ת���������
	 */
	public String BorrowBook()throws Exception{
		
		return SUCCESS;
	}
	/**
	 * ����
	 */
	public String SearchBook()throws Exception{
		if("".equals(content)||null==content){
			this.addFieldError("content","�������ݲ���Ϊ��");
			return INPUT;
		}
		HttpSession session=ServletActionContext.getRequest().getSession();
		DBServer dbs= new DBServer();
		//countΪ0��ʾû�ҵ�
		int count=0;
		if("a".equals(type)){
			ResultSet rs=dbs.SelectDatabase("books");
			while(rs.next()){
				if(-1!=rs.getString("bookname").indexOf(content)){
					count++;
				}
			}
		}else{
			ResultSet rs=dbs.SelectDatabase("books");
			while(rs.next()){
				if(-1!=rs.getString("id").indexOf(content)){
					count++;
				}
			}
		}
		if(0==count){
			session.setAttribute("empty","yes");
		}else{
			session.setAttribute("empty","no");
		}
		session.setAttribute("content",content);
		session.setAttribute("type",type);
		return SUCCESS;
	}
	
	/**
	 * ִ�н���
	 */
	public String BorrowBooksAction()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String number=(String)session.getAttribute("number");
		String bookid=null!=request.getParameter("bookid")?request.getParameter("bookid"):"";
		int stu_sum=0;
		int book_sum=0;
		String bookname=null;
		DBServer dbs= new DBServer();
		ResultSet rs_sum=dbs.SelectDatabase("student");
		while(rs_sum.next()){
			if(rs_sum.getString("number").equals(number)){
				stu_sum=rs_sum.getInt("sum");
			}
		}
		if(5==stu_sum){
			return "error";
		}
		ResultSet rs_book=dbs.SelectDatabase("books");
		while(rs_book.next()){
			if(rs_book.getString("id").equals(bookid)){
				bookname=rs_book.getString("bookname");
				book_sum=rs_book.getInt("sum");
			}
		}
		dbs.UpdateBorrowBooks(bookid, book_sum);
		dbs.UpdateBorrowStudent(number, stu_sum);
		dbs.InsertStubook(number, bookname, bookid);
		String say="����";
		Date date= new Date();
	    SimpleDateFormat sm= new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��" );
		dbs.InsertRecord(number, bookname, bookid,sm.format(date), say);
		return SUCCESS;
	}
	/**
	 * ��ת���������
	 */
	public String ReturnBook()throws Exception{
		
		return SUCCESS;
	}
	/**
	 * ִ�л����¼�
	 */
	public String ReturnBookAction()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String stubookid=null!=request.getParameter("stubookid")?request.getParameter("stubookid"):"";
		int stubook_id=Integer.parseInt(stubookid);
		String bookid=null!=request.getParameter("bookid")?request.getParameter("bookid"):"";
		HttpSession session=request.getSession();
		String number=(String)session.getAttribute("number");
		int book_sum=0;
		int stu_sum=0;
		String bookname=null;
		DBServer dbs= new DBServer();
		ResultSet rs_book=dbs.SelectDatabase("books");
		while(rs_book.next()){
			if(rs_book.getString("id").equals(bookid)){
				book_sum=rs_book.getInt("sum");
				bookname=rs_book.getString("bookname");
			}
		}
		ResultSet rs_stu=dbs.SelectDatabase("student");
		while(rs_stu.next()){
			if(rs_stu.getString("number").equals(number)){
				stu_sum=rs_stu.getInt("sum");
			}
		}
		dbs.DeleteStuBook(stubook_id);
		dbs.UpdateReturnBooks(bookid, book_sum);
		dbs.UpdateReturnBooksStudent(number, stu_sum);
		String say="����";
		Date date= new Date();
	    SimpleDateFormat sm= new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��" );
		dbs.InsertRecord(number, bookname,bookid, sm.format(date), say);
		dbs.close();
		return SUCCESS;
	}
	/**
	 * �鿴������Ϣ
	 */
	public String PersonalInfo()throws Exception{
		
		return SUCCESS;
	}
	/**
	 * �鿴�軹���¼
	 */
	public String LookRecord()throws Exception{
		return SUCCESS;
	}
	/**
	 * ɾ���軹���¼
	 */
	public String DeleteRecord()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String recordid=null!=request.getParameter("recordid")?request.getParameter("recordid"):"";
		int id=Integer.parseInt(recordid);
		DBServer dbs=new DBServer();
		dbs.DeleteRecord(id);
		dbs.close();
		return SUCCESS;
	}
	/**
	 *Get��Set���� 
	 */
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
