<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Ajax Test Page</h2>

<div>
	<div>
		게시판 번호: <input type="text" name="bno" id="newBno">
	</div>
	<div>
		댓글 작성자 : <input type="text" name="replyer" id="newReplyWriter">
	</div>
	<div>
		댓글 내용 : <textarea name="replytext" id="newReplyText"></textarea>
	</div>
	<input type="button" id="replyAddBtn" value="댓글 추가">
</div>

<h2>수정</h2>

<div id="modDiv">
	<div class="model-title"></div>
	<div><input type="text" id="replytext"></div>
	<div>
	<div><button id="replyModBtn">modify</button>
	<button id="replyDelBtn">delete</button>
	<button id="closeBtn">close</button></div>
	</div>
</div>

<ul id="replies">
	
</ul>

<!-- 다운해서 불러오는 방법 
<script type="text/javascript" src="resources/plugins/jQuery/jquery-3.4.1.js"></script>
-->
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="../resources/js/reply.js"></script>
</body>
</html>