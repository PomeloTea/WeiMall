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
    
	<script type="text/javascript" src="js/weixin.js"></script>
  
  </head>
  
  <body>
    
    <%@ include file="navbar.jsp"%>

    <%@ include file="copyright.jsp"%> 
    
  </body>
</html>