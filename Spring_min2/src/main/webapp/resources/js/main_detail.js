/**
 * 
 */

$(document).ready(function(){
	$("#opt").blur(function(){
		var opt = $("#opt").val();
		if(opt=="1"){
			opt="";
		}
		alert("opt="+opt);
	})
})