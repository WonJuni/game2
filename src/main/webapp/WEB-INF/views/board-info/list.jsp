<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Board List</h3>
	<select name="searchtype" id="searchType">
		<option value="1">Title</option>
		<option value="2">Writer</option>
		<option value="3">Content</option>
		<option value="4">Title+Content</option>
		<option value="5">Writer+Content</option>
		<option value="6">Title+Writer</option>
		<option value="7">Title+Writer+Content</option>

	</select>
	<input type="text" name="searchStr" placeholder="For..." id="searchStr">
	<button onclick="loadFunc()">Search</button>
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Title</th>
			<th>Writer</th>
			<th>Credat</th>
		</tr>
		<tbody id="tBody">
		</tbody>
	</table>
	<button onclick="location.href='/board-info/insert'">Write</button>
	<script type="text/javascript">
		function goPage(url) {
			location.href = url;
		}
		const loadFunc = function() {
			const xhr = new XMLHttpRequest();
			const searchStr = document.querySelector('#searchStr');
			const searchType = document.querySelector('#searchType');
			let url = '/json/list';
			if(searchStr.value !== ''){
				url += '?searchType=' + searchType.value + '&searchStr=' + searchStr.value;
			}
			xhr.open('GET', url);
			xhr.onreadystatechange = function() {
				if (xhr.readyState === 4) {
					if (xhr.status === 200) {
						const obj = JSON.parse(xhr.responseText);
						
						/* console.log(obj); */
						let html = '';
						for (const board of obj) {
							console.log(board);
							html += '<tr>';
							html += '<td>' + board.biNum + '</td>';
							html += '<td><a href="/views/board-info/view?biNum=' + board.biNum+'">' + board.biTitle + '</a></td>';
							html += '<td>' + board.uiName + '</td>';
							html += '<td>' + board.credat + '</td>';
							html += '</tr>';
						}
						document.querySelector('#tBody').innerHTML = html;
					}
				}

			}
			xhr.send();
		}
		window.addEventListener('load', loadFunc);
	</script>
</body>
</html>