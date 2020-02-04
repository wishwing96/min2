<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  
<script type="text/javascript" src="../resources/plugins/jQuery/jquery-3.4.1"></script>

<script src="../resources/js/uploadwrite.js"></script>-->
<link rel="stylesheet" href="../resources/css/upload.css"></link> 
</head>
<body>

<h1>글쓰기를 위한 jsp입니다.</h1>
<!-- fileupload = enctype="multipart/form-data"꼭 필요 -->
<form action="register" method="post" enctype="multipart/form-data">

<table>
	<tr>
		<td>제목</td><td><input type = "text" name="subject"></td>
	</tr>
	<tr>
		<td>내용</td><td><textarea rows="25px" cols="100px" name="content" ></textarea></td>
	</tr>
	<tr>
		<td>글쓴이</td><td><input type="text" name = "writer"></td>
	</tr>
	<tr>
		<td>조회수</td><td><input type="text" name = "cnt"></td>
	<tr>
		<td>파일</td><td><input type="file" name="fileName"></td>
	</tr>
	<tr>
		<td colspan ="2"><input type="submit" value = "등록"></td>
	</tr>

</table>
</form>



</body>
</html>



















