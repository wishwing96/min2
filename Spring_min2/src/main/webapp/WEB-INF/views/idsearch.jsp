<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search page</title>
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
				<td><a href="board1">board</a></td>
			</tr>
		</table>
		<h1><a href="main">이달의 꽃</a></h1>
		<p>A free responsive site template by</p>
	</div>
</header>

<form action="idsearch" method="post">

<div id="logbox">

<table id="login">
	<tr>
		<td>name</td>
		<td><input type="text" name="uname"></td>
		<td rowspan="2"><input type="submit" value="search"></td>
	</tr>
	<tr>
		<td>tel</td>
		<td><input type="password" name="uphone"></td>
	</tr>
	
</table>
<table>
	<c:if test="${id!=null}">
	<table>
	
		<tr><td>${id.uname}님의 ID는 ${id.uid}입니다.  ||  <a href="pwsearch">비밀번호 찾기</a></td></tr>
		
	</table>
</c:if>
</table>

</div>
</form>

</body>
</html>





























