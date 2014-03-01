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
  
  	<script type="text/javascript">
  
    <% 
	String referer = "";
	String test = "";
	referer = request.getHeader("REFERER");
	//out.println(referer);
	if(referer == null) {
		response.sendRedirect("index.jsp");
	} else {
		if(referer.endsWith("/WeiMall/index.jsp") || referer.endsWith("/WeiMall/")) {
		  	String userId = request.getParameter("userid");
		  	if(userId != null) {
		  		session.setAttribute("WeiMallId", userId);
		  		int intId = Integer.parseInt(userId);
		  		SellerDAO dao = new SellerDAO();
		  		dao.getSession().flush();
		  		Seller seller = dao.findById(intId);
		  		
		  		if(seller == null) {
		  			System.out.println("id: " + intId);
		  			System.out.println("seller: null");
		  			return;
		  		}
		  		
		  		System.out.println("session ip:" + seller.getSellerLastLoginIp());
		  		session.setAttribute("WeiMallIp", seller.getSellerLastLoginIp());
		  		
		  		String userIp;
		  		if (request.getHeader("x-forwarded-for") == null) {   
					userIp = request.getRemoteAddr();   
				} else {
					userIp = request.getHeader("x-forwarded-for");   
				}
				seller.setSellerLastLoginIp(userIp);
				//System.out.println("ip: " + userIp);
				dao.save(seller);
				
				String oldTimeString = seller.getSellerLastLoginTime();
				session.setAttribute("WeiMallTime", oldTimeString);
				System.out.println("oldTime:" + oldTimeString);
				if(oldTimeString == null) {
				%>
				console.log("newTime:" + new Date().toString());
				Database.setLoginTime(<%=userId%>, new Date().toString(), function(){
				<%response.sendRedirect("User.jsp");%>
				});
				<%} else { %>
				var oldTime = new Date("<%=oldTimeString%>");
				var newTime = new Date();
				console.log("oldDate:" + oldTime.toLocaleDateString());
				console.log("newDate:" + newTime.toLocaleDateString());
				if(oldTime.toLocaleDateString() != newTime.toLocaleDateString())
					Database.setLoginTime(<%=userId%>, newTime.toString(), function(){
				<%response.sendRedirect("User.jsp");%>
				});
				<%}
		  		//response.sendRedirect("User.jsp");
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
  
  	</script>
  	
  <body>
  	<%=session.getAttribute("WeiMallId") %>
  </body>
</html>
