<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		#d1{
			position:absolute;
			top:70;
			left:470
		}
		#d2{
		position:absolute;
		}
	</style>
  </head>
  
  <body>
    <div id="d2" style="left:50px;">
    	<img height="115" width="454" src="../image/uni1.jpg">
    </div>
    <div id="d1" style="left: 585px; width: 615px; top: 16px;">
    	<h1><font color="#c0c0c0" size="7" face="楷体"><em><strong>学*生*宿*舍*管*理*系*统</strong></em></font></h1>
    </div>
   <div style="position:absolute; right:200; top:100"><font color="#ff0080"><em> 
   		<font face="仿宋">欢迎您，${sessionScope.username} </font> 
   </em></font></div>
  </body>
</html>
