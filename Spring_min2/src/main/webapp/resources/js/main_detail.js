/**
 * 
 */
$(document).ready(function(){
	
	
	var array = new Array();
	var str="";
	
	
	for(var i=1; i<=$("#num").val(); i++){
	
		array[i] = $("#path"+i).val()+"/"+$("#uuid"+i).val()+"_"+$("#filename"+i).val()
		str = "<div class='detailImg'>"+"<img src='display?filename="+array[i]+"' width='300' height='300'>"+"<div>"
		
		$(".img").append(str);
	
	}
	
	var gdsnum = $("#gdsnum").val();
	
	$("#cart").on("click",function(){
		var cartStock = $("#cartStock").val();
		alert("cartStock="+cartStock);
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
		var no = $("#no").val();
		
		$.ajax({
			type : "post",
			url : "reply",
			contentType : "application/json",
			dataType : "text",
			data : JSON.stringify({gdsnum:gdsnum, uid:uid, repcon:repcon}),
			success:function(data){
				location.href="/controller/main_detail?no="+no;
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
				str2 += "<tr><td><input type='hidden' value='"+this.repnum+"'>" +this.repcon +"</td><td>"+this.uid 
				+"</td><td>"+ this.repdate
				+"</td><td><div class='replyFooter'>"
				+"<button type='button' class='delete' data-repnum='" + this.repnum + "'>Delete</button>"
				+"<button type='button' class='modify' data-repnum='" + this.repnum + "'>Modify</button>"
				+ "</div></td></tr>"
			});
			
			$(".replies").html(str2);
	});

	
})











































