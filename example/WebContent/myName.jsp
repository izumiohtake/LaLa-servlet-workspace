<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!--ページディレクトリ -->
    
<%
String name = "菅原　文太";
int age = 23;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPのサンプル</title>
</head>
<body>
<%--コメント --%>
<% for (int i=0 ; i<5; i++ ){ %>
私の名前は<%= name %>。年齢は<%= age %>。<br>
<% } %>
<!-- 出力される -->
</body>
</html>