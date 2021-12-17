package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex62")
public class ex62 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int odd = (int) (Math.random() * 10 % 2 = 0);
		String ;
	
	
	
	System.out.println("このサーブレットの中にきたよ");
	
	//同じプロジェクト内だけ
	String url = "/WEB-INF/jsp/forwarded.jsp";
		
	RequestDispatcher dispatcher =
			request.getRequestDispatcher(url);
	
    dispatcher.forward(request,response);
}	
	
	
	@WebServlet("/redirctedt")
	public class redircted extends HttpServlet {
		private static final long serialVersionUID = 1L;

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			System.out.println("きたよ-");
			
			//リダイレクト
	        response.sendRedirect("/ex62/redirctedt");
		}
	}

}
