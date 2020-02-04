<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write page</title>

</head>
<body>

<form action="board_write" method="post" enctype="multipart/form-data">

<c:if test="${vo!=null}">

<table>
	<tr>
		<td>subject</td><td><input type="text" name="subject"></td>
	</tr>
	<tr>
		<td>content</td><td><textarea name = "content"></textarea></td>
	</tr>
	<tr>
		<td>id</td><td><input type="text" name="uid" value = "${vo.uid}" readonly></td>
	<tr>
		<td><input type="file" name="filename"></td>
	</tr>
	<tr>
		<td colspan ="2"><input type="submit" value = "등록"></td>
	</tr>

</table>
</c:if>

</form>

</body>
</html>