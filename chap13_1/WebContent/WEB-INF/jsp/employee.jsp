<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
<p><a href="<%= request.getContextPath() %>/create"><button>新しい社員を登録</button></a></p>
<p><a href="<%= request.getContextPath() %>/delate"><button>社員を消す</button></a></p>
<div>
<form action="<%=request.getContextPath() %>/findByName" method="post">
	検索する語:<input type="text" name="name">
	<input type="submit" value="検索">
</form>
</div>	
<h1>社員一覧</h1>
<p><a href="<%= request.getContextPath() %>/create"><button>新規社員登録</button></a></p>
<table>
<tr>
<th>ID</th>
<th>名前</th>
<th>年齢</th>
</tr>

<c:forEach var="employee" items="${empList}">
<tr>
<td><c:out value="${employee.id}"/></td>
<td><c:out value="${employee.name}"/></td>
<td><c:out value="${employee.age}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>