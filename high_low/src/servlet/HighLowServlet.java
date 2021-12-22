package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Game;
import model.GameLogic;

@WebServlet("/game")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();//HttpSessionインスタンスの取得呼び出す
		String replay = request.getParameter("replay");
		Game game = null;
		String url = null;
		if(replay == null) {
			//Gameインスタンス作成
			int user = 0;
			int com = (int)(Math.random()*99) +1;
			String msg = "";
			game = new Game(user,com,msg);
			//sessionに保存
			session.setAttribute("game", game);
			url = "/play.jsp";
		}
		else if (replay.equals("yes")){
			//セッションからgameインスタンスを取得する
			game = (Game) session.getAttribute("game");
			//gameのcomの値を新しい値にする（ランダム）
			int com = (int)(Math.random()*99) + 1;
			game.setCom(com);
			url = "/play.jsp";
		}
		else if (replay.equals("end")){
			session.invalidate();
			url = "/WEB-INF/end.jsp";
		}
		
		//sessionに保存
//		session.setAttribute("game", game);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String num = request.getParameter("number");//jspのフォーム送信から受け取る
		int user = Integer.parseInt(request.getParameter("num"));// IntegerクラスparseIntメソッド
//		int com = (int) (Math.random() * 10);// userの変数と比較する
//		int com =  Integer.parseInt(request.getParameter("com"));
//		response.setContentType("text/html; charset=UTF-8");//html表示前にこの二行必須
//		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();//呼び出す
		//sessionスコープからGameインスタンスを取得する
		Game game = (Game) session.getAttribute("game");
		//Gameインスタンスに新しいuserの値をセット
		game.setUser(user);//Game.（の）javaのsetUser（int不要）
		//		String msg ="";
//		Game game = new Game(user,com,msg);//インスタンス
		
		GameLogic gameLogic = new GameLogic();
		gameLogic.execute(game);
		
//		out.println("<! DOCTYPE html><html>");
//		out.println("<body>");

//		System.out.println("user:" + user + " com:" + com + "" + msg);//サーブレットの処理の内容を表示
//		request.setAttribute("game",game);//gameクラスのインスタンスを作って入れる requestスコープ

		String url = "/play.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		// request.getContextPath() (=high_low)としてもいい
//		 out.println("<a href=\"/high_low/play.jsp\">もう一度する？</a>");
		// <a href = ""ダブルクオテーション前に識別のバッククォート、中にアプリケーション名（プロジェクト名）/URLパターン">文字</a>
//		 out.println("</body>");      
//		 out.println("</html>");      
	}
}
