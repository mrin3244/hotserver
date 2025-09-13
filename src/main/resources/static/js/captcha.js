
/* Function to Generat Captcha */
function drawCaptcha(){
    var alpha = new Array('A','B','C','D','E','F','G','H','I','J','K','L','M','N','P','Q',
						'R','S','T','U','V','W','X','Y','Z', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    var a = alpha[Math.floor(Math.random() * alpha.length)];
    var b = alpha[Math.floor(Math.random() * alpha.length)];
    var c = alpha[Math.floor(Math.random() * alpha.length)];
    var d = alpha[Math.floor(Math.random() * alpha.length)];
    var e = alpha[Math.floor(Math.random() * alpha.length)];

    
    var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' + e  ;   
   	$("#txtCaptcha").val(code); 
   	$("#txtCaptchaInput").val("");  
   	//captchaValue=a + b + c + d + e;
 }

$(document).on('blur', '#txtCaptchaInput', function() {
	//var txtCaptcha = $('#txtCaptcha').val();
	var txtCaptchaInput = $('#txtCaptchaInput').val();
	if(txtCaptchaInput != "" && !validCaptcha()){
		toastError("ERROR", "Captcha Mismatch...");
		$('#txtCaptchaInput').val("");
	}
});

/* Validating Captcha Function */
function validCaptcha() {
	var txtCaptcha = $.trim($('#txtCaptcha').val());
	var txtCaptchaInput = $.trim($('#txtCaptchaInput').val());
	var str1 = removeSpaces(txtCaptcha);
	var str2 = removeSpaces(txtCaptchaInput);
	
	if (str1 != str2) return false;
	return true;
}
 
/* Remove spaces from Captcha Code */
function removeSpaces(captcha) {
	return captcha.split(' ').join('');
}
