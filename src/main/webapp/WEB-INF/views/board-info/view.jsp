<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>View</h3>
<form action="/board-info/delete" method="POST">
<table border="1">
<input type="hidden" value="${boardInfo.biNum}" name="biNum">
<tr>
	<th>Num</th>
	<td>${boardInfo.biNum}</td>
</tr>
<tr>
	<th>Contnet</th>
	<td>${boardInfo.biContent}</td>
</tr>
<tr>
	<th>Writer</th>
	<td>${boardInfo.uiNum}</td>
</tr>
<tr>
	<th>Num</th>
	<td>${boardInfo.biNum}</td>
</tr>
<c:if test="${userInfo.uiNum eq boardInfo.uiNum}">
<tr>
	<td colspan="2" align="center"><button type="button" onclick="location.href='/board-info/update?biNum=${boardInfo.biNum}'">Update</button>
	<button type="submit">Delete</button></td>
</tr>
</c:if>
</table>
</form>
</body>
</html>