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


@WebServlet("/create")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Employee emp = new Employee(String, String, int);
		
		//ﾘｸｴｽﾄｽｺｰﾌﾟに保存
		Employee emp = CreateConfirm.execute();
		request.setAttribute("emp", emp);
//		return 
		
		// フォワード7
		String url = "/WEB-INF/jsp/createConfirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
	}

}
