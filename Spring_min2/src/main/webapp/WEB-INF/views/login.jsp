<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>
<body>

<header id="header" class="alt">
	<div class="inner">
		<table>
			<tr>
				<td><a href="login">login</a></td>
				<td><a href="join">join</a></td>
				<td><a href="cart">cart</a></td>
				<td><a href="board_list">board</a></td>
			</tr>
		</table>
		<h1><a href="main">이달의 꽃</a></h1>
		<p>A free responsive site template by</p>
	</div>
</header>

<form action="loginPost" method="post">

<div id="logbox">

<table id="login">
	<tr>
		<td>ID</td>
		<td><input type="text" name="uid"></td>
		<td rowspan="2"><input type="submit" value="LOGIN"></td>
	</tr>
	<tr>
		<td>PASSWORD</td>
		<td><input type="password" name="upw"></td>
	</tr>
	
</table>
<table>
	<tr><td><a href="idsearch">아이디 찾기</a>  ||  <a href="pwsearch">비밀번호 찾기</a></td></tr>
</table>
</div>

</form>

</body>
</html>