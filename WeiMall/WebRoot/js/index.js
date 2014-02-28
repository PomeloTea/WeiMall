var ALERT_SUCCESS = 1;
var ALERT_WARNING = 2;
var ALERT_DANGER = 3;

var LOGIN_NOUSER = -2;
var LOGIN_WRONGPASS = -1;

var REG_USEREXIST = -2;
var REG_EMAILEXIST = -1;

$(document).ready(function(){

	$('#index-register').click(function(){
		$('#register-inputName').val("");
		$('#register-inputEmail').val("");
		$('#register-inputVertification').val("");
		clear_register_alert();
	});
	
	$('#index-login').click(function(){
		$('#login-inputName').val("");
		$('#login-inputPassword').val("");
		$('#login-inputRemember').prop("checked",true);
		$('#login-alert').remove();

		//记住密码时，密码补全
		if($.cookie('WeiMallUser') != null) {
			$('#login-inputName').val($.cookie('WeiMallUser'));
			$('#login-inputPassword').val($.cookie('WeiMallPassword'));
		}
	});

	//register submit
	$('#index-register-submit').bind('click', registerSubmit);
	$('#register-inputName').bind('keyup', registerSubmit);
	$('#register-inputEmail').bind('keyup', registerSubmit);
	$('#register-inputPassword').bind('keyup', registerSubmit);
	$('#register-inputConfirm').bind('keyup', registerSubmit);
	$('#register-inputVertification').bind('keyup', registerSubmit);

	//login submit
	$('#index-login-submit').bind('click', loginSubmit);
	$('#login-inputName').bind('keyup', loginSubmit);
	$('#login-inputPassword').bind('keyup', loginSubmit);

});

//注册
function registerSubmit(event) {
	if(event.type == "click" || event.keyCode == 13) {
		var registerName = $('#register-inputName').val();
		var registerEmail = $('#register-inputEmail').val();
		var registerPassword = $('#register-inputPassword').val();
		var registerConfirm = $('#register-inputConfirm').val();
		//var registerVertification = $('#register-inputVertification').val();
		clear_register_alert();

		var registerFlag = ALERT_SUCCESS;
		var registerMsg = "";
		if(isName(registerName)) {
			$('#register-name').addClass('has-success');
		} else {
			registerFlag = ALERT_WARNING;
			$('#register-name').addClass('has-warning');
			registerMsg += "昵称只能包含中英文、数字和下划线；";
		}
		if(isEmail(registerEmail)) {
			$('#register-email').addClass('has-success');
		} else {
			registerFlag = ALERT_WARNING;
			$('#register-email').addClass('has-warning');
			registerMsg += "邮箱格式有误；";
		}
		if(isPassword(registerPassword)) {
			$('#register-password').addClass('has-success');
			if(registerPassword == registerConfirm) {
				$('#register-confirm').addClass('has-success');
			} else {
				registerFlag = ALERT_WARNING;
				$('#register-confirm').addClass('has-warning');
				registerMsg += "密码与密码确认不相同；";
			}
		} else {
			registerFlag = ALERT_WARNING;
			$('#register-password').addClass('has-warning');
			registerMsg += "密码由长度为6-20的数字、字母、下划线组成";
		}

		if(registerFlag == ALERT_SUCCESS) {
			Database.regseller(registerName, registerEmail, registerPassword, registerCallback);
		} else {
			var info = generate_alert(registerFlag, registerMsg, "register-alert");
			$('#register-form').prepend(info);
			$('#register-alert').hide();
			$('#register-alert').fadeIn(500);
		}
	}
}

//登录
function loginSubmit(event) {
	if(event.type == "click" || event.keyCode == 13) {
		var loginName = $('#login-inputName').val();
		var loginPassword = $('#login-inputPassword').val();
		$('#login-alert').remove();
		
		Database.checkseller(loginName,loginPassword,loginCallback);
	}
}

//注册回调函数
function registerCallback(msg) {
	var type, content;
	if(msg == REG_USEREXIST) {
		type = ALERT_DANGER;
		content = "用户名已存在";
		$('#register-name').removeClass('has-success');
		$('#register-name').addClass('has-error');
	} else if(msg == REG_EMAILEXIST) {
		type = ALERT_DANGER;
		content = "邮箱已存在";
		$('#register-email').removeClass('has-success');
		$('#register-email').addClass('has-error');
	} else if(msg >= 0) {
		type = ALERT_SUCCESS;
		content = "注册成功";
	} else {
		type = ALERT_DANGER;
		content = "注册失败";
	}
	
	var info = generate_alert(type, content, "register-alert");
	$('#register-form').prepend(info);
	$('#register-alert').hide();
	$('#register-alert').fadeIn(500, function(){
		if(type == ALERT_SUCCESS) {
			setTimeout(function(){
				$('#registerModal').modal('hide');
				}, 500);
			//设置userid，提交表单
			$('#login-userid').val(msg);
			$('#login-form').submit();
		}
	});
}

//登录回调函数
function loginCallback(msg) {
	
	var type, content;
	if(msg == LOGIN_NOUSER) {
		type = ALERT_DANGER;
		content = "用户不存在";
	} else if(msg == LOGIN_WRONGPASS) {
		type = ALERT_DANGER;
		content = "密码错误";
	} else if(msg >= 0) {
		type = ALERT_SUCCESS;
		content = "登陆成功";
	} else {
		type = ALERT_DANGER;
		content = "登录失败";
	}
	
	var info = generate_alert(type, content, "login-alert");
	$('#login-form').prepend(info);
	$('#login-alert').hide();
	$('#login-alert').fadeIn(500, function(){
		if(type == ALERT_SUCCESS) {
			setTimeout(function(){
				$('#loginModal').modal('hide');
				}, 500);
			var loginName = $('#login-inputName').val();
			var loginPassword = $('#login-inputPassword').val();
			var loginRemember = $('#login-inputRemember').is(':checked');
			if(loginRemember) {
				$.cookie('WeiMallUser', loginName, { expires: 7 });
				$.cookie('WeiMallPassword', loginPassword, { expires: 7 });
			} else {
				$.cookie('WeiMallUser', null);
				$.cookie('WeiMallPassword', null);
			}
			//设置userid，提交表单
			$('#login-userid').val(msg);
			$('#login-form').submit();
		}
		else {
			$.cookie('WeiMallUser', null);
			$.cookie('WeiMallPassword', null);
		}
	});
}

//验证昵称格式
function isName(name) {
	var patten = new RegExp(/^[\u4E00-\u9FA5A-Za-z0-9_]+$/);
	return patten.test(name);
}

//验证邮箱格式
function isEmail(email) {
	var patten = new RegExp(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]+$/);
	return patten.test(email);
}

//验证密码格式
function isPassword(password) {
	var patten = new RegExp(/^(\w){6,20}$/);
	return patten.test(password);
}

function clear_register_alert() {
	$('#register-inputPassword').val("");
	$('#register-inputConfirm').val("");
	$('#register-name').removeClass('has-success');
	$('#register-name').removeClass('has-warning');
	$('#register-name').removeClass('has-error');
	$('#register-email').removeClass('has-success');
	$('#register-email').removeClass('has-warning');
	$('#register-email').removeClass('has-error');
	$('#register-password').removeClass('has-success');
	$('#register-password').removeClass('has-warning');
	$('#register-password').removeClass('has-error');
	$('#register-confirm').removeClass('has-success');
	$('#register-confirm').removeClass('has-warning');
	$('#register-confirm').removeClass('has-error');
	$('#register-vertification').removeClass('has-success');
	$('#register-vertification').removeClass('has-warning');
	$('#register-vertification').removeClass('has-error');
	$('#register-alert').remove();
}

//生成错误提示代码
function generate_alert(type, content, id) {
	var module1 = '<div id="';
	var module2 = '" class="alert alert-';
	var module3 = ' alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><strong>';
	var module4 = '！</strong> ';
	var module5 = '</div>';
	var info;
	switch(type) {
	case ALERT_SUCCESS:
		info = module1 + id + module2 + 'success' + module3 + '成功' + module4 + content + module5;
		break;
	case ALERT_WARNING:
		info = module1 + id + module2 + 'warning' + module3 + '警告' + module4 + content + module5;
		break;
	default:
		info = module1 + id + module2 + 'danger' + module3 + '错误' + module4 + content + module5;
		break;
	}
	return info;
}