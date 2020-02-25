<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="org.springframework.web.servlet.mvc.support.RedirectAttributes"  %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board page</title>
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
<form method="get">
<div id="logbox">
<table id="login">

	<tr><td>번호</td><td>${detail.no}</td></tr>
	<tr><td>subject</td><td>${detail.subject}</td></tr>
	<tr><td>content</td><td>${detail.content}</td></tr>
	<tr><td>date</td><td>${detail.write_date}</td></tr>
	<tr><td>id</td><td>${detail.uid}</td></tr>
	<tr><td>file</td><td><img src="displayFile?fileName=/${detail.file}" width="300" height="300"></td></tr>
	<tr>
		<td colspan="2">
		<c:if test="${vo!=null}">
			<a href="board_modify?no=${detail.no}">modify||</a>
			<a href="board_delete?no=${detail.no}">delete||</a>
		</c:if>
			<a href="board_list">list</a>
		</td>
	</tr>

</table>
</div>
</form>

</body>
</html>