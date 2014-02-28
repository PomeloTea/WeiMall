var ALERT_SUCCESS = 1;
var ALERT_WARNING = 2;
var ALERT_DANGER = 3;

$(document).ready(function(){
	
	$('#mallTag').removeClass('active');
	$('#weixinTag').removeClass('active');
	$('#userTag').addClass('active');
	
	$('#submit').bind('click', saveSellerInfo);
	$('#realName').bind('keyup', saveSellerInfo);
	$('#birthday').bind('keyup', saveSellerInfo);
	$('#qq').bind('keyup', saveSellerInfo);
	$('#phoneNum').bind('keyup', saveSellerInfo);
	
});

function saveSellerInfo(event) {
	if(event.type == "click" || event.keyCode == 13) {
		var userId = $('#userId').text();
		var realName = $('#realName').val();
		var birthday = $('#birthday').val();
		var sex = $("input[name='sex']:checked").val();
		var qq = $('#qq').val();
		var phoneNum = $('#phoneNum').val();
		
		$('#save-info-alert').remove();
		$('#realNameDiv').removeClass('has-warning');
		$('#birthdayDiv').removeClass('has-danger');
		$('#sexDiv').removeClass('has-danger');
		$('#qqDiv').removeClass('has-danger');
		$('#phoneNumDiv').removeClass('has-danger');
		
		if(realName.length > 20) {
			$('#realNameDiv').addClass('has-warning');
			generate_alert(ALERT_WARNING, "��ʵ�������ó���20���ַ�");
			return;
		}
		
		Database.saveSellerInfo(userId, realName, sex, birthday, qq, phoneNum, function(msg){
			//ret = 0 ��Ϣ����ɹ�
			//ret = 1 ��ʵ�������ȴ���
			//ret = 2 qq�����Ϲ淶
			//ret = 3 �ֻ��Ų����Ϲ淶
			//ret = 4 ���Ҳ�����
			switch(msg) {
			case 0:
				generate_alert(ALERT_SUCCESS, "��Ϣ����ɹ�");
				break;
			case 1:
				$('#realNameDiv').addClass('has-danger');
				generate_alert(ALERT_DANGER, "��ʵ�������ȴ���");
				break;
			case 2:
				$('#qqDiv').addClass('has-danger');
				generate_alert(ALERT_DANGER, "qq�����Ϲ淶");
				break;
			case 3:
				$('#phoneNumDiv').addClass('has-danger');
				generate_alert(ALERT_DANGER, "�ֻ��Ų����Ϲ淶");
				break;
			default:
				generate_alert(ALERT_DANGER, "���Ҳ�����");
				break;
			}
		});
		
	}
}

//���ɴ�����ʾ����
function generate_alert(type, content) {
	var id="save-info-alert";
	var module1 = '<div id="';
	var module2 = '" class="alert alert-';
	var module3 = ' alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button><strong>';
	var module4 = '��</strong> ';
	var module5 = '</div>';
	var info;
	switch(type) {
	case ALERT_SUCCESS:
		info = module1 + id + module2 + 'success' + module3 + '�ɹ�' + module4 + content + module5;
		break;
	case ALERT_WARNING:
		info = module1 + id + module2 + 'warning' + module3 + '����' + module4 + content + module5;
		break;
	default:
		info = module1 + id + module2 + 'danger' + module3 + '����' + module4 + content + module5;
		break;
	}

	$('#save-info-form').prepend(info);
	$('#save-info-alert').hide();
	$('#save-info-alert').fadeIn(500);
}