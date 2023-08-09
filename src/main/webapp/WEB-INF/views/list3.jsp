<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>num</th>
			<th>name</th>
			<th>age</th>
			<th>address</th>
		</tr>
		<tbody id="tBody">
		
		</tbody>
	</table>
	<script type="text/javascript">
		const getFunc = function(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						const obj = JSON.parse(xhr.responseText)
						
						let html = '';
						for(let info of obj){
							html += '<tr>';
							html += '<td>' + info.num + '</td>';
							html += '<td>' + info.name + '</td>';
							html += '<td>' + info.age + '</td>';
							html += '<td>' + info.address + '</td>';
							html += '<tr>';
						}
						document.querySelector('#tBody').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load', getFunc);
	</script>
</body>
</html>