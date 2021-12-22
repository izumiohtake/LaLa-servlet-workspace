package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//最初にサ－ブレット(doGetメソッド)にアクセスさせて、ｊｓｐにいくのがノ－マル
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/WEB-INF/jsp/healthCheck.jsp";
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String weight = request.getParameter("weight");//文字列でくる
		String height = request.getParameter("height");//文字列でくる
		
		Health health = new Health();
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));
		
		HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
		//healthのもっているもの　health.setBodyType(bodyType)＆health.setBmi(bmi)
		healthCheckLogic.execute(health);//healthCheckLogicに渡す
		
		request.setAttribute("health", health);
		
		String url = "/WEB-INF/jsp/healthCheckResult.jsp";
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(url);
		dispatcher.forward(request,response);
		
	}

}
