<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>send mail</h4>

<form action="mail" method="post">
to : <input type="text" name="tomail" value="wishwing96@naver.com" readonly> 
title : <input type="text" name="title">
content : <textarea name="content"></textarea>
from : <input type="text" name="from">

<input type="submit" value="emailsend"> 
</form>

</body>
</html>