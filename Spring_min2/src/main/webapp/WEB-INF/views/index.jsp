<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>메인페이지 입니다.</h1>
<form action="ex01" method="post">
	<table border="1">
		<tr>
			<th colspan="2"> 테스트용</th>
		</tr>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>나이</td><td><input type="text" name="age"></td>
		</tr>	
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>
	</table>

</form>
</body>
</html>