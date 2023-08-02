<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Board List</h3>
	<form action="/board-info/list" method="GET">
		<select name="searchtype">
			<option value="1">Title</option>
			<option value="2">Writer</option>
			<option value="3">Content</option>
			<option value="4">Title+Content</option>
			<option value="5">Writer+Content</option>
			<option value="6">Title+Writer</option>
			<option value="7">Title+Writer+Content</option>

		</select> <input type="text" name="searchStr" placeholder="For...">
		<button>Search</button>
	</form>
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Title</th>
			<th>Writer</th>
			<th>Credat</th>
		</tr>
		<c:forEach items="${boardInfoList}" var="boardInfo">
			<tr>
				<td>${boardInfo.biNum }</td>
				<td><a href="/board-info/view?biNum=${boardInfo.biNum}">${boardInfo.biTitle }</a></td>
				<td>${boardInfo.uiName }</td>
				<td>${boardInfo.biCredat }</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="location.href='/board-info/insert'">Write</button>
</body>
</html>