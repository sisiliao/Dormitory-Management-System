<!-- this is login page -->
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
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
			left:280px;
			top:0px;
			height:200;
			width:790;
		}
		#d2{
			position:absolute;
			left:280px;
			top:270px;
			height:200;
		}
		#d3{
			position:absolute;
			z-index:1;
			border-style:double;
			border-color:green;
			background-color:white;
			opacity:0.7;
		}
		
	</style>
	
	<script>
		var type = false;
		function register(){
			if(document.getElementById("d4").style.display=="none"){
				type=true;
				//document.getElementById("d4").style.display="block";
			}else
			{
				type=false;
				//document.getElementById("d4").style.display="none";
			}
			if(type==true){
				document.getElementById("d4").style.display="block";
			}if(type==false){
				document.getElementById("d4").style.display="none";
			}
		}
		function init(){
			document.getElementById("d4").style.display="none";
		}
		function aww(){
			document.getElementById("dqrc").style.display="block";
		}
		function oww(){
			document.getElementById("dqrc").style.display="none";
		}
	</script>
	
  </head>

	<body onload="init()">
		<div id="d1">
			<img src="image/uni1.jpg" />
			<p align="center" font-size="xx-large"><font size="6" color="#c0c0c0"><strong><font face="楷体">学*生*宿*舍*管*理*系*统</font></strong></font></p>
		</div>
		
		<div id="d2">
			<img src="image/uni3.jpg" style="top: 3px; left: 0px; width: 782px; height: 366px;">
		</div>
		<div id="d3" style="left: 796px; width: 224px; top: 417px; height: 173px;">
			<form action="AdminServlet?action=login" method="post">
				<p align="center"><b>请登陆</b></p>
			 	&nbsp;&nbsp;<b>账号：</b><input type="text" name="username"/><br>
			 	<br>
			 	&nbsp;&nbsp;<b>密码：</b><input type="password" name="password"/><br>
			 	<p align="center" ><input type="submit" value="登陆"/>
			 	<input type="button" value="新用户注册" onclick="register()"/>
			</form>
		</div>
		<div id="d4" style="border: double; border-color:green; position: absolute; top: 418px; left: 563px; width: 218px; height: 174px; background-color: white; opacity:0.7;">
			<form action="AdminServlet?action=register" method="post">
				<p align="center"><b>新用户注册</b></p>
			 	&nbsp;&nbsp;<b>账号：</b><input type="text" name="username"/><br>
			 	<br>
			 	&nbsp;&nbsp;<b>密码：</b><input type="password" name="password"/><br>
			 	<p align="center" ><input type="submit" value="注册"/>
			</form>
		</div>
		<div id="dpanguin" style="position:absolute; left:1150; top:400;">
			<img src="image/panguin.jpg" onmouseover="aww()" onmouseout="oww()"></img>
			<br>~点我下嘛~
		</div>
		<div id="dqrc" style="display:none; position:absolute; left:1150; top:300;">
			<img src="image/qrcode.jpg"></img>
		</div>
	 </body>
</html>
