<%@page import="hibernate.SellerDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <%@ include file="head.jsp"%>
    
	<script type="text/javascript" src="js/user.js"></script>
	<link rel="stylesheet" type="text/css" href="css/user.css">
  
  </head>
  
  <body>
    
    <%@ include file="navbar.jsp"%>
    
    <div id="userId" style="display: none"><%=userId %></div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-4" >
				<img id="user-img" src="image/default-avatar.png" class="img-rounded img-responsive" />
				<div class="container">
					<%	String sellerLastLoginTime = (String)session.getAttribute("WeiMallTime");
						if(sellerLastLoginTime != null) { %>
					<div class="row">
						<div class="nopadding col-sm-2">上次登录时间</div>
						<div class="col-sm-3" id="lastLoginTime">
						</div>
						<script>
						var date = new Date("<%=sellerLastLoginTime%>");
						$('#lastLoginTime').html(date.toLocaleString());
						</script>
					</div>
					<%} %>
					<%	String sellerLastLoginIp = (String)session.getAttribute("WeiMallIp");
						if(sellerLastLoginIp != null) { %>
					<div class="row">
						<div class="nopadding col-sm-2">上次登录IP</div>
						<div class="col-sm-3"><%=sellerLastLoginIp%></div>
					</div>
					<%} %>
					<%	Integer sellerCredit = seller.getSellerCredit();
				      		if(sellerCredit != null) { %>
					<div class="row">
						<div class="nopadding col-sm-2">卖家信用</div>
						<div class="col-sm-3"><%=sellerCredit%></div>
					</div>
					<%} %>
					<%	Integer sellerEvaluation = seller.getSellerGoodEvaluationNum();
			      		if(sellerEvaluation != null) { %>
					<div class="row">
						<div class="nopadding col-sm-2">好评数</div>
						<div class="col-sm-3"><%=sellerEvaluation%></div>
					</div>
					<%} %>
					<%	Integer sellerLevel = seller.getSellerShopLevel();
			      		if(sellerLevel != null) { %>
					<div class="row">
						<div class="nopadding col-sm-2">店铺等级</div>
						<div class="col-sm-3"><%=sellerLevel%></div>
					</div>
					<%} %>
					<%	String sellerValidity = seller.getSellerValidity();
			      		if(sellerValidity != null) { %>
					<div class="row">
						<div class="nopadding col-sm-2">有效期</div>
						<div class="col-sm-3"><%=sellerValidity%></div>
					</div>
					<%} %>
					<%	Integer sellerGoodsOnSell = seller.getSellerGoodsOnSell();
			      		if(sellerGoodsOnSell != null) { %>
					<div class="row">
						<div class="nopadding col-sm-2">发布商品数</div>
						<div class="col-sm-3"><%=sellerGoodsOnSell%></div>
					</div>
					<%} %>
					<%	Integer sellerTotolGoodsNum = seller.getSellerTotalGoodsNum();
			      		if(sellerTotolGoodsNum != null) { %>
					<div class="row">
						<div class="nopadding col-sm-2">商品总数</div>
						<div class="col-sm-3"><%=sellerTotolGoodsNum%></div>
					</div>
					<%} %>
				</div>
			</div>
			<div class="col-md-8">
				<h3>个人资料</h3><hr>
				<form class="form-horizontal" role="form" id="save-info-form">
				  <div class="form-group">
				    <label for="name" class="col-sm-2 control-label">昵称</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" id="name" value="<%=seller.getSellerName() %>" readonly>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="email" class="col-sm-2 control-label">邮箱</label>
				    <div class="col-sm-10">
				      <input type="email" class="form-control" id="email" value="<%=seller.getSellerEmail() %>" readonly>
				    </div>
				  </div>
				  <div class="form-group" id="realNameDiv">
				    <label for="realName" class="col-sm-2 control-label">真实姓名</label>
				    <div class="col-sm-10">
				      <input type="text" name="realName" class="form-control" id="realName" value="<%
				      	String sellerName = seller.getSellerRealName();
				      	if(sellerName != null) {
				      		out.print(sellerName); } %>">
				    </div>
				  </div>
				  <div class="form-group" id="birthdayDiv">
				    <label for="birthday" class="col-sm-2 control-label">生日</label>
				    <div class="col-sm-10">
				      <input type="date" name="birthday" class="form-control" id="birthday" value="<%=seller.getSellerBirthday() %>">
				    </div>
				  </div>
				  <div class="form-group" id="sexDiv">
				    <div class="col-sm-offset-2 col-sm-10">
				      <div class="radiobox">
				      	<%	Integer sellerSex = seller.getSellerSex();
				      		String checked = "checked";
				      		if(sellerSex != null && sellerSex == 0) { %>
				        <label>
							<input type="radio" name="sex" value="1" /> 男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        </label>
				        <label>
							<input type="radio" name="sex" value="0" checked /> 女
				        </label>
				        	<%} else { %>
				        <label>
							<input type="radio" name="sex" value="1" checked /> 男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        </label>
				        <label>
							<input type="radio" name="sex" value="0" /> 女
				        </label>
				        	<%} %>
				      </div>
				    </div>
				  </div>
				  <hr />
				  <div class="form-group" id="qqDiv">
				    <label for="qq" class="col-sm-2 control-label">QQ</label>
				    <div class="col-sm-10">
				      <input type="text" name="qq" class="form-control" id="qq" value="<%
				      String sellerQq = seller.getSellerQq(); 
				      if(sellerQq != null) { 
				      	out.print(sellerQq); } %>">
				    </div>
				  </div>
				  <div class="form-group" id="phoneNumDiv">
				    <label for="phoneNum" class="col-sm-2 control-label">手机</label>
				    <div class="col-sm-10">
				      <input type="text" name="phoneNum" class="form-control" id="phoneNum" value="<%
				      	String sellerPhoneNum = seller.getSellerPhoneNum();
				      	if(sellerPhoneNum != null) {
				      		out.print(sellerPhoneNum); } %>">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-7 col-sm-2">
				      <button type="button" class="btn btn-default">修改密码</button>
				    </div>
				    <div class="col-sm-1">
				      <button id="submit" type="button" class="btn btn-default">保存</button>
				    </div>
				  </div>
				  <hr />
				</form>
			</div>
		</div>
	</div>

    <%@ include file="copyright.jsp"%> 
    
  </body>
</html>
