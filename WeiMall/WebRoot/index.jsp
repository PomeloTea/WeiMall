<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="head.jsp"%>
    <script type="text/javascript" src="js/index.js"></script> 
	<%
	
	session.setAttribute("WeiMallId", null);
	session.setAttribute("WeiMallTime", null);
	session.setAttribute("WeiMallIp", null);
	
	String temp = (String)session.getAttribute("WeiMallId");
	if(temp != null) {
		response.sendRedirect("User.jsp");
	}
	%>
  </head>
  
  <body>
  	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	  <!-- Brand and toggle get grouped for better mobile display -->
	  <div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	      <span class="sr-only">Toggle navigation</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="#">微猫 WeiMall</a>
	  </div>

	  <!-- Collect the nav links, forms, and other content for toggling -->
	  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    <p class="navbar-text">
	    	<a href="#" class="navbar-link" data-toggle="modal" data-target="#registerModal">注册</a>加入微猫~
	    </p>
	    <ul class="nav navbar-nav navbar-right">
	    	<div class="btn-group">
		    	<button id="index-register" type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#registerModal">
		    		<span class="glyphicon glyphicon-registration-mark"></span>
		    		注册
		    	</button>
		    	<button id="index-login" type="button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#loginModal">
		    		<span class="glyphicon glyphicon-log-in"></span>
		    		登录
		    	</button>
			</div>
	    </ul>
	  </div><!-- /.navbar-collapse -->
	</nav>

	<!-- register Modal -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel">注册</h4>
	      </div>
	      <div class="modal-body">
	        <form id="register-form" class="form-horizontal" role="form">
			  <div id="register-name" class="form-group">
			    <label for="register-inputName" class="col-sm-2 control-label">昵称</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="register-inputName" placeholder="breeze">
			    </div>
			  </div>
			  <div id="register-email" class="form-group">
			    <label for="register-inputEmail" class="col-sm-2 control-label">邮箱</label>
			    <div class="col-sm-10">
			      <input type="email" class="form-control" id="register-inputEmail" placeholder="breeze@weixinmall.com">
			    </div>
			  </div>
			  <div id="register-password" class="form-group">
			    <label for="register-inputPassword" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="register-inputPassword" placeholder="123456">
			    </div>
			  </div>
			  <div id="register-confirm" class="form-group">
			    <label for="register-inputConfirm" class="col-sm-2 control-label">密码确认</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="register-inputConfirm" placeholder="123456">
			    </div>
			  </div>
			  <div id="register-vertification" class="form-group">
			    <label for="register-inputVertification" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="register-inputVertification">
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        <button id="index-register-submit" type="button" class="btn btn-primary">
		    		<span class="glyphicon glyphicon-registration-mark"></span>
		    		注册
		    	</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<!-- login Modal -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel">登录<small>&nbsp;请用昵称或邮箱登录</small></h4>
	      </div>
	      <div class="modal-body">
	        <form id="login-form" class="form-horizontal" role="form" method="post" action="SessionSet.jsp">
	          <input type="text" id="login-userid" name="userid" style="display: none;">
			  <div id="login-name" class="form-group">
			    <label for="login-inputName" class="col-sm-2 control-label">昵称/邮箱</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="login-inputName" placeholder="breeze/breeze@weixinmall.com">
			    </div>
			  </div>
			  <div id="login-password" class="form-group">
			    <label for="login-inputPassword" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="login-inputPassword" placeholder="123456">
			    </div>
			  </div>
			  <div id="login-remember" class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input id="login-inputRemember" type="checkbox"> 记住我
			        </label>
			      </div>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		    	<button id="index-login-submit" type="button" class="btn btn-primary">
		    		<span class="glyphicon glyphicon-log-in"></span>
		    		登录
		    	</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
    	
	<nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
		<center>Copyright ©2014 All Rights Reserved</center>
	</nav>
  </body>
</html>
