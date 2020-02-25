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
				<c:if test="${vo==null}">
			<table>
				<tr>
					<td><a href="login">login</a></td>
					<td><a href="join">join</a></td>
					<td><a href="login">cart</a></td>
					<td><a href="board_list">board</a></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${vo!=null && vo.uid.equals('admin')==false}">
			<table>
				<tr>
					<td><a href="information">${vo.uname}님 환영합니다.</a></td>
					<td><a href="logout">logout</a></td>
					<td><a href="cartList">cart</a></td>
					<td><a href="board_list">board</a></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${vo.uid.equals('admin')}">

			<table>
				<tr>
					<td><a href="register">${vo.uname}님 환영합니다.</a></td>
					<td><a href="logout">logout</a></td>
					<td><a href="board_list">board</a></td>
					<td><a href="adminOrder">order</a></td>
				</tr>
			</table>
	
		</c:if>
		<h1><a href="main">이달의 꽃</a></h1>
		<p>A free responsive site template by</p>
	</div>
</header>

<form action="pwsearch" method="post">

<div id="logbox">

<table id="login">
	<tr>
		<td>id</td>
		<td><input type="text" name="uid"></td>
		<td rowspan="2"><input type="submit" value="search"></td>
	</tr>
	<tr>
		<td>uname</td>
		<td><input type="text" name="uname"></td>
	</tr>
	
</table>
<table>
	<c:if test="${pw!=null}">
	<table>
	
		<tr><td>${pw.uname}님의 ID는 ${pw.upw}입니다.</tr>
		
	</table>
</c:if>
</table>

</div>
</form>

</body>
</html>