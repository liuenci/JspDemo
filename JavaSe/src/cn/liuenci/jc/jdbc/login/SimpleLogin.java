package cn.liuenci.jc.jdbc.login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SimpleLogin extends JFrame implements ActionListener{
	private JButton btnOk,btnCancel;
	private JPanel jpbtn,jpMain;
	private JLabel lblName,lblPassword;
	private JTextField jtfName;
	private JPasswordField jtfpassword;
	
	public SimpleLogin(String s) {
		super(s);
		
		jpbtn = new JPanel();
		btnOk = new JButton("确认");
		btnCancel = new JButton("取消");
		jpbtn.add(btnOk);
		jpbtn.add(btnCancel);
		
		jpMain = new JPanel();
		lblName = new JLabel("用户名:");
		lblPassword = new JLabel("密    码:");
		jtfName = new JTextField(15);
		jtfpassword = new JPasswordField(15);
		jpMain.add(lblName);
		jpMain.add(jtfName);
		jpMain.add(lblPassword);
		jpMain.add(jtfpassword);
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		
		Container con = this.getContentPane();
		con.add(jpbtn,BorderLayout.SOUTH);
		con.add(jpMain,BorderLayout.CENTER);
		
		this.setLocation(300, 300);
		this.setSize(250, 150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk) {
			if(isUser(jtfName.getText(), new String(jtfpassword.getPassword()))){
				this.dispose();
				JOptionPane.showMessageDialog(null,"登录成功","登录成功",JOptionPane.INFORMATION_MESSAGE);
				newWindow(); 
			}else {
				JOptionPane.showMessageDialog(null,"登录失败","登录失败",JOptionPane.INFORMATION_MESSAGE);
				jtfName.setText("");
				jtfpassword.setText("");
			}
		}else {
			System.exit(0);
		}
		
	}
	public void newWindow() {
		JFrame mMDI = new JFrame("主窗口");
		mMDI.setSize(800, 800);
		mMDI.setLocationRelativeTo(null);
		mMDI.setVisible(true);
		mMDI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static boolean isUser(String no,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			
		}
		//创建连接对象
		Connection con = null;
		//创建PreparedStatement对象
		PreparedStatement pstmt = null;
		//创建结果集对象
		ResultSet rs = null;
		int flag = 0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tsgc", "root", "123456");
			String strsql = "select * from employee where no = ? and password = ?";
			pstmt = con.prepareStatement(strsql);
			pstmt.setString(1, no);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				flag ++;
			}
			if(flag==0) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			}catch(SQLException e) {
				
			}
			try {
				pstmt.close();
			}catch(SQLException e) {
			}
			try {
				con.close();
			}catch(SQLException e) {
				
			}
		}
		return true;
	}
	public static void main(String[] args) {
		SimpleLogin login = new SimpleLogin("登录");
	}

}
