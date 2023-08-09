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
			<th>Name</th>
			<th>Age</th>
			<th>Address</th>
		</tr>
		<tbody id="tBody">
		</tbody>
	</table>
	<script type="text/javascript">
		const loadFunc = function(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/list');
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						const obj = JSON.parse(xhr.responseText);
						console.log(obj);
						let html = '';
						
						for(let info of obj){
							html += '<tr>';
							html += '<td>' + info.name + '</td>';
							html += '<td>' + info.age + '</td>';
							html += '<td>' + info.address + '</td>';
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