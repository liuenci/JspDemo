package booksManage.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BackgroundCheckLogin extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	/**
	 * ��ת����̨��½����
	 */
	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
	/**
	 * ��֤��̨��½
	 */
	public String CheckBackLogin()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		if("������".equals(name)&&"123".equals(pwd)){
			HttpSession session=request.getSession();
			session.setAttribute("admin",name);
			return SUCCESS;
		}
		return "error";
	}
	/**
	 * �˳�
	 */
	public String Back()throws Exception{
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
	/**
	 * ������һҳ
	 */
	public String Back1()throws Exception{
		
		return SUCCESS;
	}
}
