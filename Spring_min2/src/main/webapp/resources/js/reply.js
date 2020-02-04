/**
 * 
 */
var bno=1;
var str=null;
$.getJSON("../replies/all/"+bno,function(data){
	console.log(data.length);
	
	$(data).each(
			function() {
			str += "<li data-rno='"+this.rno+"' class='replyLi'>"
			+this.replytext 
			+ "<input type='button' value='modify'>"
			+"</li>"
		});
	$("#replies").html(str);
});

$("#replyAddBtn").on("click", function(){
	var bno = $("#newBno").val();
	var replyer = $("#newReplyWriter").val();
	var replytext = $("#newReplyText").val();
	
	$.ajax({
		type:"post",
		url:"../replies",
		contentType : "application/json",
		dataType:"text",
		data: JSON.stringify({bno:bno, replyer:replyer, replytext:replytext}),
		success:function(data){
				alert("OK");
			},
		error : function(err){
				alert("error");
			}
			
		});
});

$("#replies").on("click", ".replyLi input", function(){
	var reply = $(this).parent();//자신.부모(자신의 부모요소는 reply)
	
	var rno = reply.attr("data-rno");
	var replytext = reply.text();
	
	$(".model-title").html(rno);
	$("#replytext").val(replytext);
	$("#modDiv").show("slow");
	
	alert(rno + ":" + replytext);
});

$("#replyDelBtn").on("click", function(){
	var rno = $(".model-title").html();
	var replytext = $("#replytext").val();
	
	$.ajax({
		type:"delete",
		url:"../replies/"+rno,
		contentType:"application/json",
		dataType:"text",
		data:JSON.stringify({replytext:replytext}),
		success:function(data){
			alert("OK");
			$("#modDiv").hide("slow");
			getAllList();
		},
		error : function(err){
			alert("error");
		}
	});
});

$("#replyModBtn").on("click", function(){
	var rno = $(".model-title").html();
	var replytext = $("#replytext").val();
	
	$.ajax({
		type:"put",
		url:"../replies/"+rno,
		contentType:"application/json",
		dataType:"text",
		data:JSON.stringify({replytext:replytext}),
		success:function(data){
			alert("OK");
			$("#modDiv").hide("slow");
			getAllList();
		},
		error : function(err){
			alert("error");
		}
	});
});

















