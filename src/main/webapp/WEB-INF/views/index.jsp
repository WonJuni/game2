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
<h3>Main</h3>

<c:if test="${userInfo eq null}">
<button onclick="location.href='/user-info/login'">Login</button>
<button onclick="location.href='/user-info/insert'">Join</button>
</c:if>

<c:if test="${userInfo ne null}">
${userInfo.uiName} 님 환영합니다!<br>
<button onclick="location.href='/user-info/logout'">Logout</button>
</c:if>

<ul>
	<li><a href="/board-info/list">Board</li>
</ul>

</body>
</html>