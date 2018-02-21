package cn.dao.test;

import java.util.Map;
import java.util.Map.Entry;

import cn.common.model.Employee;
import cn.database.db.DBUtil;

public class Test extends DBUtil{

	public Employee get() {
		String sql = "select * from EMPLOYEE where EMPID = 2";
		Map<String,Object> map = query(sql);
		System.out.println(map);
		Employee employee = new Employee();
		for(Entry<String,Object> e : map.entrySet()) {
			if(e.getKey().equals("EMPID")) {
				employee.setEmpId(Integer.parseInt(e.getValue().toString()));
			}else if(e.getKey().equals("EMPNAME")){
				employee.setName(e.getValue().toString());
			}
		}
		return employee;
	}
	public static void main(String[] args) {
		System.out.println(new Test().get().getEmpId());
	}

}
