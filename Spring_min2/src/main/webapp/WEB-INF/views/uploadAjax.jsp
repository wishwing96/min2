<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.fileDrop{
weight:300px;
height:300px;
background-color:gray;
}
</style>
</head>
<body>

<h3>Ajax File Upload</h3>
<div class="fileDrop"></div>
<div class="uploadedList"></div>

<form action="adminpage" method="post" enctype="multipart/form-data">
<input type="hidden" id="file" value="fileDrop">
<input type="text" id="name">
<input type="text" id="amount">
</form>

<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/upload.js"></script>



</body>
</html>