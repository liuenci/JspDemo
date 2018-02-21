package booksManage.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBServer {
	
	private Connection con=null;
	private Statement stat=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	public DBServer(){
		UtilCon conn= new UtilCon();
		con=conn.getConn();
	}
	
	/**
	 * 查询数据库
	 */
	public ResultSet SelectDatabase(String name){
		try {
			stat=con.createStatement();
			String sql="select * from "+name+"";
			rs=stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/*
	 *增加学生信息 
	 */
	public void InsertStuInfo(String number,String name,String sex,String classes,String dept){
		String sql="insert into student values(?,?,?,?,?,?);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,number);
			ps.setString(2,name);
			ps.setString(3,sex);
			ps.setString(4,classes);
			ps.setString(5,dept);
			ps.setInt(6,0);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 增加图书信息
	 */
	public void InsertBooksInfo(String id,String name,String type,int sum){
		String sql="insert into books values(?,?,?,?);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,type);
			ps.setInt(4,sum);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 修改图书信息
	 */
	public void UpdateBookInfo(String id,String name,String type,int sum){
		String sql="update books set bookname=?,type=?,sum=? where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,type);
			ps.setInt(3,sum);
			ps.setString(4,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除学生信息
	 */
	public void DeleteStu(String number){
		String sql="delete from student where number=?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,number);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除图书信息
	 */
	public void DeleteBookInfo(String id){
		String sql="delete from books where id=?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 借书。。。修改books表的sum
	 */
	public void UpdateBorrowBooks(String bookid,int book_sum){
		--book_sum;
		String sql="update books set sum=? where id=?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,book_sum);
			ps.setString(2,bookid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 借书。。修改student表中的sum
	 */
	public void UpdateBorrowStudent(String number,int stu_sum){
		++stu_sum;
		String sql="update student set sum=? where number=?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,stu_sum);
			ps.setString(2,number);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 借书。。插入stubook数据
	 */
	public void InsertStubook(String number,String bookname,String bookid){
		String sql="insert into stubook(number,bookname,bookid) values(?,?,?);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,number);
			ps.setString(2,bookname);
			ps.setString(3,bookid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 增加借书、还书记录
	 */
	public void InsertRecord(String number,String bookname,String bookid,String time,String say){
		String sql="insert into record(number,bookname,bookid,time,say) values(?,?,?,?,?);";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,number);
			ps.setString(2,bookname);
			ps.setString(3,bookid);
			ps.setString(4,time);
			ps.setString(5,say);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * 还书。。。从stubook中删除数据
	 */
	public void DeleteStuBook(int stubook_id){
		String sql="delete from stubook where id=?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,stubook_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 还书。。。更新books中的sum
	 */
	public void UpdateReturnBooks(String bookid,int book_sum){
		++book_sum;
		String sql="update books set sum=? where id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,book_sum);
			ps.setString(2,bookid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 还书。。更新student中sum
	 */
	public void UpdateReturnBooksStudent(String number,int stu_sum){
		--stu_sum;
		String sql="update student set sum=? where number=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,stu_sum);
			ps.setString(2,number);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除记录。。。从record中删除
	 */
	public void DeleteRecord(int id){
		String sql="delete from record where id=?;";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 关闭打开的流
	 */
	public void close(){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
