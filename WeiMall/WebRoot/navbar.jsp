<%@page import="hibernate.Seller"%>
<%@page import="hibernate.SellerDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
	
	<form id="logout-form" method="post" action="SessionSet.jsp">
	</form>
	<%	String StrId = (String)session.getAttribute("WeiMallId");
	   	int userId = 0;
	   	Seller seller = new Seller();
	   	if(StrId == null) {
	   		response.sendRedirect("index.jsp");
	   	} else {
	   		userId = Integer.parseInt(StrId);
			SellerDAO dao = new SellerDAO();
			seller = dao.findById(userId);
	   	}%>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">΢è WeiMall</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li id="userTag" class="active"><a href="User.jsp">�˻�����</a></li>
          <li id="mallTag"><a href="Mall.jsp">�̳ǹ���</a></li>
          <li id="weixinTag"><a href="Weixin.jsp">΢�Ź���</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li class="disabled"><p id="welcome-info" class="navbar-text">��ӭ����
          	<span id="user-name">
          		<%=seller.getSellerName()%>
          	</span>
          </p></li>
          <li>
	      	<a id="logout" data-toggle="modal" data-target="#logoutModal">
	    		<span class="glyphicon glyphicon-log-out"></span>
	    		�ǳ�
		    </a>
		  </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </nav>
    
    <!-- logout Modal -->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel">�ǳ�</h4>
	      </div>
	      <div class="modal-body">
	      	<p>ȷ��Ҫ�ǳ���</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">ȡ��</button>
	    	<button id="logout-submit" type="button" class="btn btn-primary">
	    		<span class="glyphicon glyphicon-log-out"></span>
	    		�ǳ�
	    	</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
