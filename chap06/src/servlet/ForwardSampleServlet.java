package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForwardSampleServlet")
public class ForwardSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("このサーブレットの中にきたよ");
		
		//同じプロジェクト内だけ
		String url = "/WEB-INF/jsp/forwardSample.jsp";
			
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		
        dispatcher.forward(request,response);
}	
}
