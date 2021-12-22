<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Human" %>
<%
	Human human = (Human) request.getAttribute("human");//オブジェクト型をHuman型にキャスト
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サンプル</title>
</head>
<body>
<h1>human</h1>
<p>名前：<%= human.getName() %></p>
<p>年齢：<%= human.getAge() %></p>
</body>
</html>