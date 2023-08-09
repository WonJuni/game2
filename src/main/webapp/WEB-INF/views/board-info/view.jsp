<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>View</h3>
	<table border="1">
		<tr>
			<th>Num</th>
			<td id="biNum">${param.biNum}</td>
		</tr>
		<tr>
			<th>Title</th>
			<td id="biTitle"></td>
		</tr>
		<tr>
			<th>Content</th>
			<td id="biContent"></td>
		</tr>
		<tr>
			<th>Writer</th>
			<td id="uiName"></td>
		</tr>
		<tr>
			<th>credat</th>
			<td id="credat">${boardInfo.credat}</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="button"
					onclick="goPage('/board-info/update?biNum=${board.biNum}')">수정</button>
				<button>삭제</button>
			</th>
		</tr>
	</table>
	<script type="text/javascript">
		function goPage(url) {
			location.href = url;
		}
		function loadFunc() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/json/one?biNum=${param.biNum}');
			xhr.onreadychange = function() {
				if (xhr.readyState === 4) {
					if (xhr.status === 200) {
						console.log(xhr.responseText);
						const board = JSON.parse(xhr.responseText);
						console.log(board);
						for(let key in board){
							console.log(key)
							if(document.querySelector('#'+key)){
								document.querySelector('#'+key).innerText = board[key];
							}
						}
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load', loadFunc)
	</script>
</body>
</html>