<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Game"%>
<%
	Game game = (Game) session.getAttribute("game");//ゲームというクラスの運び役beans 最初gameはnull
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- スクリプト式=イコール忘れない JSPファイルにJavaのコードを埋め込める-->
	<form action="<%=request.getContextPath()%>/game" method="post">
		<!--/judgeウェブアノテーション!-->
		<!-- request.getContextPath()=直で書かない=high_lowのこと-->
		0～99の数を入力： <input type="number" name="num"> <!--nameの値が大事-->
		              <input type="submit" value="送信">
	</form>
	 
	<% if(game != null){ %>
	<h2>結果</h2>
	<p>user:<%= game.getUser() %> </p>
	<p>com:<%= game.getCom() %> </p>
	<p><%= game.getMsg() %></p>
	<% } %>
	<!--equest.getContextPath()=hige_lowのこと  -->
	<a href="<%=request.getContextPath()%>/game?replay=yes">
	      <button>別の数字でやる</button></a>
	 <a href="<%=request.getContextPath()%>/game?replay=end">
	      <button>やめる</button></a>     
	
</body>
</html>