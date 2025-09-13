$(document).ready(function() {
	//on load
	drawCaptcha();
});


$(document).on('click', '#btnSubmit', function() {
	var username = $.trim($('#username').val());
	var password = $.trim($('#password').val());
	if(username == ""){
		toastError("ERROR", "Provide your username...!!");
	}else if(password == ""){
		toastError("ERROR", "Provide your password...!!");
	}else if(!validCaptcha()){
		toastError("ERROR", "Captcha mismatch...!!");
	}else{
		$.ajax({
			url : "login",
			type : "POST",
			data : {'userId':username, 'password':password},
			dataType : "json",
			success : function(data) {
				 //alert(data.msg);
				if(data.msg == "success"){
					window.location.href = "/home";
				} else {
					toastError("ERROR", data.msg);
				}
			},
			error:function(){
				toastError("ERROR", "Connection error...");
			}
		});
	}
});
