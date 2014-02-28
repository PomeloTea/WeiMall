$(document).ready(function(){
	
	if($.cookie('WeiMallState') == null) {
		//window.location.href = '#';
	}
	
	$('#logout-submit').click(function(){
		$('#logout-form').submit();
	});
	
});