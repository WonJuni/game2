<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
 <tr>
 	<th>Num</th>
 	<th>Name</th>
 	<th>Desc</th>
 </tr>
 <tbody id="tBody">
 </tbody>
</table>
</body>
<script type="text/javascript">
	const getTest = function(){
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/test-info/list')
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4){
				if(xhr.status === 200){
					const obj = JSON.parse(xhr.responseText);
					html = '';
					for(let info of obj){
						html += '<tr>';
						html += '<td>' + info.tiNum + '</td>';
						html += '<td>' + info.tiName + '</td>';
						html += '<td>' + info.tiDesc + '</td>';
						html += '</tr>';
					}
					document.querySelector('#tBody').innerHTML = html;
				}	
			}
		}
		xhr.send();
	}
	window.addEventListener('load', getTest);
</script>
</html>