<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Update</h3>
<form action="/board-info/update" method="POST">
<input type="hidden" name="biNum" value="${boardInfo.biNum}">
<input type="text" name="biTitle" placeholder="${boardInfo.biTitle}"><br>
<input type="text" name="biContent" placeholder="${boardInfo.biContent}"><br>
<button>OK</button>
</form>
</body>
</html>