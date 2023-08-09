<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>유저 리스트</h3>
	<div class="container">
		<table class="container" border="1">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">이름</th>
					<th scope="col">아이디</th>
					<th scope="col">비밀번호</th>
				</tr>
			</thead>
			<tbody id="tBody">

			</tbody>
		</table>
	</div>
	<a href="/user-info/insert">등록</a>

	<script type="text/javascript">
		function goPage(url){
			location.href=url;
		}
		const loadFunc = function(){
			const xhr = new XMLHttpRequest();
			let url = '/user-info/list'
			xhr.open('GET', url);
			xhr.onreadystatechange = function(){
				if(xhr.readyState === 4){
					if(xhr.status === 200){
						const obj = JSON.parse(xhr.responseText);
						
						let html ='';
						for(const user of obj){
							html += '<tr>';
							html += '<td>' + user.uiNum + '</td>';
							html += '<td>' + user.uiName + '</td>';
							html += '<td>' + user.uiId + '</td>';
							html += '<td>' + user.uiPwd + '</td>';
							html += '</tr>';
							console.log(user);
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