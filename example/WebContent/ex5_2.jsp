<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><form action="example/testenq" method="post">
<textarea name="name" rows="4" cols="10">名前を入力</textarea><br>
<p>お問い合わせの種類：<br>
<select name="qtype">
<option value="1">会社について</option>
<option value="2">製品について</option>
<option value="3">アフタ－サポ－トについて</option>
</select>
</form>
</body>
</html>