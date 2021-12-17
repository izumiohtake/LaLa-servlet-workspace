<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int com = (int)(Math.random()*10);
String comtxt = String.valueOf(com);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- スクリプト式=イコール忘れない JSPファイルにJavaのコードを埋め込める-->
<form action = "<%=request.getContextPath()%>/judgem" method="post"><!--/judgeウェブアノテーション!-->
<!-- request.getContextPath()=直で書かない=high_lowのこと-->
0～9の数を入力：
<input type="hidden" name="com" value = "<%= comtxt%>"><br>
<input type="number" value="num">
<input type="submit" value="送信">
</form>
</body>
</html>