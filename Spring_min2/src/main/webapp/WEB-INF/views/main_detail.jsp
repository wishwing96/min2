<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="resources/css/join.css">
<link rel="stylesheet" type="text/css" href="resources/css/main_detail.css">
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script src="resources/js/main_detail.js"></script>
<style>
 div.replyModal { position:relative; z-index:1; display:none;}
 div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
 div.modalContent { position:fixed; top:20%; left:calc(50% - 250px); width:500px; height:250px; padding:20px 10px; background:#fff; border:2px solid #666; }
 div.modalContent textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px; height:200px; }
 div.modalContent button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 div.modalContent button.modal_cancel { margin-left:20px; }
</style>
</head>
<body>
		<!-- Header -->
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

<form method="post" name="form1">
<c:forEach items="${file}" var="file" varStatus="status">

	<input type="hidden" value="${file.uploadPath }" id="path${status.count}">
	<input type="hidden" value="${file.uuid }" id="uuid${status.count}">
	<input type="hidden" value="${file.filename}" id="filename${status.count}">

</c:forEach>

<input type="hidden" value="${num }" id="num">

<div class="img"></div>
<div id="a">
<table border="1">
	<tr><td>꽃 종류</td><td>${us.name}</td></tr>
	<tr><td>가격</td><td>${us.price }원</td></tr>
	<tr><td>설명</td><td>${us.proexplain }</td></tr>
	<tr><td>수량</td><td><input type="text" id="cartStock" value="1">개</td></tr>
	<c:if test="${vo==null}">
		<tr><th colspan="2">구매를 원하시면 <a href="login">로그인</a>을 해주세요.</th></tr>
	</c:if>
	<c:if test="${vo!=null }">
	<tr><th colspan="2"><a href="order?no=${us.no}"><input type="button" value="구매하기"></a>||
						<a href="cartList"><input type="button" value="장바구니" id="cart"></a></th></tr>
	</c:if>
</table>
<input type="hidden" value="${us.no }" id="no">
</div>
<div class="replybox">
	<c:if test="${vo==null}">
		<p>댓글 남기려면 <a href="login">로그인</a>하러가기</p>
	</c:if>
	
	<c:if test="${vo!=null}">
		<input type="hidden" name="gdsnum" id="gdsnum" value="${us.no}">
		<input type="hidden" name="uid" id="uid" value="${vo.uid}">
		<table border="1">
		
			<tr><td colspan="4"><textarea id="repcon"></textarea>
			<input type="button" id="reply" value="reply" ></td></tr>
			<tr><td colsapn="5"><div class="replies"></div></td></tr>
			
		</table>
		
		
	</c:if>
</div>
<div class="replyModal">

 <div class="modalContent">
  
  <div>
   <textarea class="repcon" name="repcon"></textarea>
  </div>
  
  <div>
   <button type="button" class="modify_btn">수정</button>
   <button type="button" class="modal_cancel">취소</button>
  </div>
  
 </div>

 <div class="modalBackground"></div>
 
</div>

<script>
	var no = $("#no").val();
	$(document).on("click", ".delete", function(){
		var data = {repnum : $(this).attr("data-repnum")};
			
		$.ajax({
			url : "replyDel",
			type : "post",
			data : data,
			success : function(result){
				if(result=1){
					location.href="/controller/main_detail?no="+no;
				}else{
					alert("작성자 본인만 삭제가 가능합니다.");
				}
			}
		});
	});
	
	$(document).on("click", ".modify", function(){
		 $(".replyModal").attr("style", "display:block;");
		 
		 var repnum = $(this).attr("data-repnum");
		 $(".modify_btn").attr("data-repnum", repnum);
	});
	$(document).on("click", ".modal_cancel", function(){
		 $(".replyModal").attr("style", "display:none;");
	});
	
	$(document).on("click", ".modify_btn", function(){
		alert($(this).attr("data-repnum"));
		var data = {repnum : $(this).attr("data-repnum"),
					repcon : $(".repcon").val()};
		$.ajax({
			url : "replyMod",
			type : "post",
			data : data,
			success : function(result){
				if(result=1){
					 $(".replyModal").attr("style", "display:none;");
					 location.href="/controller/main_detail?no="+no;
				}else{
					alert("작성자 본인만 수정이 가능합니다.");
				}
			}
		});
		
	});	
	
</script>

</form>


</body>
</html>






























