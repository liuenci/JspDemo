package booksManage.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BackgroundCheckLogin extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 跳转到后台登陆界面
	 */
	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}
	/**
	 * 验证后台登陆
	 */
	public String CheckBackLogin()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		if("赵瑶瑶".equals(name)&&"123".equals(pwd)){
			HttpSession session=request.getSession();
			session.setAttribute("admin",name);
			return SUCCESS;
		}
		return "error";
	}
	/**
	 * 退出
	 */
	public String Back()throws Exception{
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
	/**
	 * 返回上一页
	 */
	public String Back1()throws Exception{
		
		return SUCCESS;
	}
}
