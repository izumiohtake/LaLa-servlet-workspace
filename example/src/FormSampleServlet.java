

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormSampleServlet")
public class FormSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, //requestにユ－ザ－が送ってきた内容が入っている
			HttpServletResponse response) 
					throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		System.out.println("name:" + name + "gender:" + gender);
		
		String errorMsg = "";
		if(name == null || name.length() == 0) {
			if(name == null || name.length() == 0) {
				errorMsg +="名前が入力されていません<br>";
			}
			if (gender == null || gender.length() == 0) {
				errorMsg +="性別が入力されていません<br>";
			} else {
				if(gender.equals("0")) {gender = "男性";}
				else if(gender.equals("1")) {gender = "女性";}
			}
			
			//表示するメッセージを設定
		String msg = name + "さん(" + gender + ")を登録しました";
		if(errorMsg.length() !=0) {
			msg = errorMsg;
		}
		
		//htmlを出力

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>ユ－ザ－登録結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("</body>");
		out.println("</html>");
		}
	}

}
