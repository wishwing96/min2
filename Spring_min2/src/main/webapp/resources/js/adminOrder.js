/**
 * 
 */

$(document).ready(function(i){
	
	var checkArr = []; 
	
	 $("input[name='check']:checked").each(function(){
		 alert("aaa");
		 checkArr.push($(this).val());  
	 }) 
	         
	  

		$("#post").on("click", function(){
			  alert("check="+checkArr);
			var orderno = $("#orderno").val();
			alert(orderno);
			var state = 1;
			$.ajax({
				type : "put",
				url : "state/"+orderno,
				contentType : "application/json",
				dataType : "text",
				data : JSON.stringify({state:state}),
				success	: function(data){
					alert("ok");
				},
				error : function(err){
					alert("error");
				}
			})
		})
		$("#completion"+num).on("click", function(){
			alert(num);
			var orderno = $("#orderno"+num).val();
			alert(orderno);
			var state = 2;
			$.ajax({
				type : "put",
				url : "state/"+orderno,
				contentType : "application/json",
				dataType : "text",
				data : JSON.stringify({state:state}),
				success	: function(data){
					alert("ok");
				},
				error : function(err){
					alert("error");
				}
			})
		})
	
});