<%@page import="hibernate.Seller"%>
<%@page import="hibernate.SellerDAO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="data.Database"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SessionSet.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type='text/javascript' src="dwr/engine.js"></script>      
	<script type='text/javascript' src="dwr/util.js"></script>
	<script type='text/javascript' src="dwr/interface/Database.js"></script>

  </head> 
  
    <% 
	String referer = "";
	String test = "";
	referer = request.getHeader("REFERER");
	out.println(referer);
	if(referer == null) {
		response.sendRedirect("index.jsp");
	} else {
		if(referer.endsWith("/WeiMall/index.jsp") || referer.endsWith("/WeiMall/")) {
		  	String userId = request.getParameter("userid");
		  	if(userId != null) {
		  		session.setAttribute("WeiMallId", userId);
		  		int intId = Integer.parseInt(userId);
		  		SellerDAO dao = new SellerDAO();
		  		Seller seller = dao.findById(intId);
		  		
		  		Date oldTime = null;
		  		Date newTime = new Date();
		  		System.out.println("Time:");
		  		String temp = seller.getSellerLastLoginTime();
		  		if(temp != null) {
		  			oldTime = new Date(temp);		
			  		if(newTime.getYear() == oldTime.getYear() &&
			  			newTime.getMonth() == oldTime.getMonth() && 
			  			newTime.getDate() == oldTime.getDate()) {
			  			newTime = oldTime;
			  		}
			  		session.setAttribute("WeiMallTime", oldTime.toLocaleString());
		   			System.out.println("oldTime: " + oldTime.toLocaleString());
			  	} else {
			  		session.setAttribute("WeiMallTime", null);
			  	}
		   		System.out.println("newTime: " + newTime.toLocaleString());
		  		
		  		String userIp;
		  		if (request.getHeader("x-forwarded-for") == null) {   
					userIp = request.getRemoteAddr();   
				} else {
					userIp = request.getHeader("x-forwarded-for");   
				}
		   		System.out.println("ip: " + userIp);
		   	
		   		System.out.println("String:" + newTime.toString());
		  		session.setAttribute("WeiMallIp", seller.getSellerLastLoginIp());
		  		
		  		System.out.println("time: " + newTime.toString() + " ip: " + userIp);
		  		
		  		//Database.setLoginTimeAndIP(intId, newTime.toString(), userIp);
		  		response.sendRedirect("User.jsp");
		  	} else {
		  		response.sendRedirect("index.jsp");
		  	}
	  	} else if(referer.endsWith("/WeiMall/User.jsp") || 
	  	referer.endsWith("/WeiMall/Weixin.jsp") || 
	  	referer.endsWith("/WeiMall/Mall.jsp")) {
	  		session.setAttribute("WeiMallId", null);
	  		response.sendRedirect("index.jsp");
	  	}
	}
	%>
  
  <body>
  	<%=session.getAttribute("WeiMallId") %>
  </body>
</html>
