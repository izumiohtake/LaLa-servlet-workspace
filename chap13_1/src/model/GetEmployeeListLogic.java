package model;

import java.util.List;

import dao.EmployeeDAO;

public class GetEmployeeListLogic {
	public List<Employee> execute() {
		EmployeeDAO dao = new EmployeeDAO();//3
		List<Employee> empList = dao.findAll();//5
		return empList;
	}
}