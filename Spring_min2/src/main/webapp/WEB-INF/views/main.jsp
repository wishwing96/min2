<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/main.js"></script>
</head>
<body>

	<header id="header" class="alt">
		<div class="inner">
		<c:if test="${vo==null}">
			<table>
				<tr>
					<td><a href="login">login</a></td>
					<td><a href="join">join</a></td>
					<td><a>cart</a></td>
					<td><a href="board_list">board</a></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${vo!=null}">
			<table>
				<tr>
					<td><a href="information">${vo.uname}님 환영합니다.</a></td>
					<td><a href="logout">logout</a></td>
					<td><a>cart</a></td>
					<td><a href="board_list">board</a></td>
				</tr>
			</table>
		</c:if>
			<h1><a href="main">이달의 꽃</a></h1>
			<p>A free responsive site template by</p>
		</div>
	</header>

<c:if test="${vo.uid.equals('admin')}">

	<table border="1">
		<tr>
			<td><a href="information">${vo.uname}님 환영합니다.</a></td>
			<td><a href="adminpage">상품등록</a></td>
			<td><a>cart</a></td>
			<td><a href="#">구매상황</a></td>
		</tr>
	</table>

</c:if>
<div id="item">
<table>
<c:forEach items="${list}" var="list">
 
 <tr>
 	<td><img src="displayFile?fileName=/${list.mainfile}"></td>
 </tr>

 <tr>
 	<td><a href="main_detail?no=${list.no}">${list.name}</a></td>
 </tr>
</c:forEach>
</table>
</div>
</body>
</html>






















