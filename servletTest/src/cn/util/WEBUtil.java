package cn.util;

import cn.bean.UserFormBean;

public class WEBUtil {
	UserFormBean userFormBean = null;
	public WEBUtil(String address,String userName,String email,int userAge,String birthday) {
		setFormBean(address, userName, email, userAge, birthday);
	}
	//��װ
	public void setFormBean(String address,String userName,String email,int userAge,String birthday) {
		userFormBean = new UserFormBean();
		userFormBean.setAddress(address);
		userFormBean.setUserName(userName);
		userFormBean.setEmail(email);
		userFormBean.setUserAge(userAge);
		userFormBean.setBirthday(birthday);
	}
	//��������
	public void checkData() {
		
	}
	//��������
	public void copyData() {
		
	}
}
