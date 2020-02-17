<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write page</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/adminUpload.js"></script>
<script src="resources/ckeditor/ckeditor.js"></script>
</head>
<body>

<form action="adminpage" method="post" enctype="multipart/form-data">
<table>

	<tr><td>상품 이름</td><td><input type="text" name="name"></td></tr>
	<tr><td>상품 설명</td>
	<td>	
		<textarea rows="" cols="" id="proexplain" name="proexplain"></textarea>
		<script>
			 var ckeditor_config = {
			   resize_enaleb : false,
			   enterMode : CKEDITOR.ENTER_BR,
			   shiftEnterMode : CKEDITOR.ENTER_P,
			 };
 
			 CKEDITOR.replace("proexplain", ckeditor_config);
		</script>
	</td></tr>
	<tr><td>상품 개수</td><td><input type="text" name="amount"></td></tr>
	<tr><td>상품 가격</td><td><input type="text" name="price"></td></tr>
	<tr><td>상품 이미지</td><td><input type="file" name="uploadFile" multiple></td></tr>
	<div class="uploadResult">
	
		<ul></ul>
	
	</div>
	<tr><td colspan="2"><input type="submit" value="등록"></td></tr>
	
</table>
</form>




</body>
</html>