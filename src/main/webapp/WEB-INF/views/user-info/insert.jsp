<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/user-info/insert" method="POST"><br>
<input type="text" name="uiId" placeholder="ID"><br>
<input type="text" name="uiPwd" placeholder="PWD"><br>
<input type="text" name="uiName" placeholder="Name"><br>
<input type="text" name="uiDesc" placeholder="Desc"><br>
<input type="text" name="uiBirth" placeholder="Birth"><br>
<button>Ok</button>
</form>
</body>
</html>