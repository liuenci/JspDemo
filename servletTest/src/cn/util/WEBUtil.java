package cn.util;

import cn.bean.UserFormBean;

public class WEBUtil {
	UserFormBean userFormBean = null;
	public WEBUtil(String address,String userName,String email,int userAge,String birthday) {
		setFormBean(address, userName, email, userAge, birthday);
	}
	//封装
	public void setFormBean(String address,String userName,String email,int userAge,String birthday) {
		userFormBean = new UserFormBean();
		userFormBean.setAddress(address);
		userFormBean.setUserName(userName);
		userFormBean.setEmail(email);
		userFormBean.setUserAge(userAge);
		userFormBean.setBirthday(birthday);
	}
	//检验数据
	public void checkData() {
		
	}
	//复制数据
	public void copyData() {
		
	}
}
