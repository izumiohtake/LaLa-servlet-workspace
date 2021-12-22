package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
		//
		//
		if (mutterList == null) {
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}

		//
		//
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			// フォワード
			String url = "/WEB-INF/jsp/main.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		//入力値チェック
		if(text != null && text.length() !=0) {
			//アプリケーションスコープに保存された
			ServletContext application = this.getServletContext();
			@SuppressWarnings("unchecked")//無視
			List<Mutter> mutterList = 
					(List<Mutter>) application.getAttribute("mutterList");
			
			//
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			//
			Mutter mutter = new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter, mutterList);
			
			//
			application.setAttribute("mutterList", mutterList);
		} 
		else {
			//エラー
			request.setAttribute("errorMsg", "つぶやきが入力されていません");	}
		
		
		
		//メイン画面にフォワード
				String url = "/WEB-INF/jsp/main.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request,response);
	}
}
