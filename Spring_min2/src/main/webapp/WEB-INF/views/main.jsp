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
					<td><a>${vo.uname}님 환영합니다.</a></td>
					<td><a href="logout">logout</a></td>
					<td><a href="register">register</a></td>
					<td><a href="adminOrder">order</a></td>
				</tr>
			</table>
	
		</c:if>
			<h1><a href="main">이달의 꽃</a></h1>
			<p>A free responsive site template by</p>
		</div>
	</header>


<table>

<c:forEach items="${list}" var="list" varStatus="status">

	<input type="hidden" value="${list.uploadPath }" id="path${status.count}">
	<input type="hidden" value="${list.uuid }" id="uuid${status.count}">
	<input type="hidden" value="${list.filename}" id="filename${status.count}">
<div id="item">
	<div class="img${status.count}"></div>
	
	<script>
	

	$(document).ready(function(){
		var str="";
			
			var file=$("#path${status.count}").val()+$("#uuid${status.count}").val()+"_"+$("#filename${status.count}").val();
			
			str = "<div>"+"<img src='display?filename="+file+"' width='300' height='300'></div><br>"
			
			$(".img${status.count}").append(str);
					
			
		
	});
	
	</script>


 	<a href="main_detail?no=${list.no}">${list.name}</a>

</div>
</c:forEach>


</table>

</body>

</html>






















