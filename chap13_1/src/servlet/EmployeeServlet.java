package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmployeeListLogic;


@WebServlet("/employee")//1
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		GetEmployeeListLogic getEmployeeListLogic =//2
				new GetEmployeeListLogic();
		
		//ﾘｸｴｽﾄｽｺｰﾌﾟに保存
		List<Employee> employeeList = getEmployeeListLogic.execute();
		request.setAttribute("employeeList", employeeList);//6
		
		
		// フォワード7
		String url = "/WEB-INF/jsp/employee.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
