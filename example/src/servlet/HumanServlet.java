package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Human;

@WebServlet("/human")
public class HumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Human human = new Human("石橋蓮司",70);
		request.setAttribute("human",human);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/Human.jsp");
		dispatcher.forward(request,response);
	}
}