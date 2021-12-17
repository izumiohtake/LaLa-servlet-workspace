package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/judge")
public class HighLowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HighLowServlet() {
        super();      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String num = request.getParameter("number");//jspのフォーム送信から受け取る
		int user =  Integer.parseInt(request.getParameter("num"));//IntegerクラスparseIntメソッド
//		int com = (int)(Math.random()*10);//userの変数と比較する
		int com =  Integer.parseInt(request.getParameter("com"));
		response.setContentType("text/html; charset=UTF-8");//html表示前にこの二行必須
		PrintWriter out = response.getWriter();
		
		out.println("<! DOCTYPE html><html>");
		out.println("<body>");
		
		if(user > com) {
			out.println("大きすぎます");
		} else if (user < com){
			out.println("小さすぎます");
		}else {
			out.println("正解です");
		}
		 //request.getContextPath() (=high_low)としてもいい
		 out.println("<a href=\"/high_low/play.jsp\">もう一度する？</a>");
		 //<a href = ""ダブルクオテーション前に識別のバッククォート、中にアプリケーション名（プロジェクト名）/URLパターン">文字</a>
		 out.println("</body>");      
		 out.println("</html>");      
	}
}
