/**
 * 
 */
$(document).ready(function(){
	
	
	var array = new Array();
	var str="";
	
	
	for(var i=1; i<=$("#num").val(); i++){
	
		array[i] = $("#path"+i).val()+"/"+$("#uuid"+i).val()+"_"+$("#filename"+i).val()
		str = "<div>"+"<img src='display?filename="+array[i]+"' width='300' height='300'>"+"<div>"
		
		$(".img").append(str);
	
	}
	
	var gdsnum = $("#gdsnum").val();
	
	$("#cart").on("click",function(){
		var cartStock = $("#cartStock").val();
		
		var data = {
				num : gdsnum,
				cartStock : cartStock
		};
		
		$.ajax({
			url : "cart",
			type : "post",
			data : data,
			success : function(){
				alert("카트담기 성공");
			},
			error : function(err){
				alert("error");
			}
		})
	})
	
	$("#reply").on("click", function(){
		
		var uid =  $("#uid").val();
		var repcon = $("#repcon").val();
		
		$.ajax({
			type : "post",
			url : "reply",
			contentType : "application/json",
			dataType : "text",
			data : JSON.stringify({gdsnum:gdsnum, uid:uid, repcon:repcon}),
			success:function(data){
				alert("ok");
			},
			error : function(err){
				alert("error");
			}
		})
		
	});
	
var str2="";
	
	$.getJSON("replyList/"+gdsnum, function(data){
		$(data).each(
			function(){
				str2 += "<tr><td>"+"<li data-repnum='"+this.repnum+"'class='replyLi'>"
				+ this.repcon +"</td><td>"+this.uid +"</td><td>"+this.repdate
				+"</td><td>"+"<input type='button' value='delete' id='delete'>"
				+"</li>"+"</td></tr>"
			});
			
			$(".replies").html(str2);
	});

	$("#delete").on("click", function(){
		alert("aaaa");
		/*var rno = $(".model-title").html();
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
		});*/
	});
	
	$("#opt").blur(function(){
		var opt = $("#opt").val();
		if(opt=="1"){
			opt="";
		}
		alert("opt="+opt);
	})
	

	
	
})











































