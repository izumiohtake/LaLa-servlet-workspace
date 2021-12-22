<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="model.User" %>
<%
//sessionスコープからユ－ザ－情報を登録
User loginUser = (User) session.getAttribute("loginUser");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<% if (loginUser != null){ %>
 <p>ログインにせいこうしました</p>
 <p>ようこそ<%= loginUser.getName() %>さん</p>
 <a href="/docoTsubu/Main">つぶやきへ</a>
<% }else {%>
<p>ログインに失敗しました</p>
<a href="/docoTsubu/">TOPへ</a>
<% } %>
</body>
</html>