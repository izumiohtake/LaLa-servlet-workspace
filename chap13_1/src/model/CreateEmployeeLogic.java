package model;

import dao.EmployeeDAO;

public class CreateEmployeeLogic {
	public boolean execute(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
//		dao.create(employee);// データベースに自動保存される
		if (dao.create(emp)) {
			return true;
		}
		return false;
	}
}