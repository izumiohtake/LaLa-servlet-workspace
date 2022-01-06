<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規社員登録</title>
</head>
<body>
<form action="/13_1/create" method="post">
<input type="text" name="id">ID<br>
<input type="text" name="text">名前<br>
<input type="text" name="age">年齢<br><!-- postデータ取得できてなければ、nameの値確かめる!!!!!!!!!! -->
<input type="submit" value="確認"><br>
</form>
</body>
</html>