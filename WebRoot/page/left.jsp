<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function openl1(){
			document.getElementById("l1").style.display ="block";	
			document.getElementById("l2").style.display ="none";	
			document.getElementById("l3").style.display ="none";	
			document.getElementById("l4").style.display ="none";	
			document.getElementById("l5").style.display ="none";	
		}
		function openl2(){
			document.getElementById("l1").style.display ="none";	
			document.getElementById("l2").style.display ="block";	
			document.getElementById("l3").style.display ="none";	
			document.getElementById("l4").style.display ="none";	
			document.getElementById("l5").style.display ="none";	
		}
		function openl3(){
			document.getElementById("l1").style.display ="none";	
			document.getElementById("l2").style.display ="none";	
			document.getElementById("l3").style.display ="block";	
			document.getElementById("l4").style.display ="none";	
			document.getElementById("l5").style.display ="none";	
		}
		function openl4(){
			document.getElementById("l1").style.display ="none";	
			document.getElementById("l2").style.display ="none";	
			document.getElementById("l3").style.display ="none";	
			document.getElementById("l4").style.display ="block";	
			document.getElementById("l5").style.display ="none";	
		}
		function openl5(){
			document.getElementById("l1").style.display ="none";	
			document.getElementById("l2").style.display ="none";	
			document.getElementById("l3").style.display ="none";	
			document.getElementById("l4").style.display ="none";	
			document.getElementById("l5").style.display ="block";	
		}
		function menulist(){
			document.getElementById("menu").style.display="block";
		}
		function hidemenu(){
			document.getElementById("menu").style.display="none";
		}
	</script>
  </head>
  
  <body>
    <div id="l1" style="display:none; position: absolute; left: 140px; top: 79;">
   		 <img src="../image/u115_line.png" style=" width: 65px; height: 6px;"> 
    </div>
    <div id="l2" style="display:none; position: absolute; left: 140px; top: 160;">
   		 <img src="../image/u115_line.png" style=" width: 65px; height: 6px;"> 
    </div>
    <div id="l3" style="display:none; position: absolute; left: 140px; top: 243;">
   		 <img src="../image/u115_line.png" style=" width: 65px; height: 6px;"> 
    </div>
    <div id="l4" style="display:none; position: absolute; left: 140px; top: 324;">
   		 <img src="../image/u115_line.png" style=" width: 65px; height: 6px;"> 
    </div>
    <div id="l5" style="display:none; position: absolute; left: 140px; top: 407;">
   		 <img src="../image/u115_line.png" style=" width: 65px; height: 6px;"> 
    </div>
  	<div style="position:absolute; top:30; left:50;">
    <table border="0" >
    	<tr>
    		<td><img src="../image/building.jpg" width="67" height="78"></img></td>
    		<td>&nbsp;&nbsp;&nbsp;&nbsp;<font color="#ff00ff"><strong><a href="../BuildingServlet?action=select" target="right" onclick="openl1()">楼宇管理</a></strong></font></td>
    	</tr>
    	<tr>
    		<td><img src="../image/tv.jpg" width="67" height="78"></img></td>
    		<td>&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="../DormServlet?action=select" target="right" onclick="openl2()">宿舍管理</a></strong></td>
    	</tr>
    	<tr>
    		<td><img src="../image/stubook.jpg" width="67" height="78"></img></td>
    		<td>&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="../StuServlet?action=select" target="right" onclick="openl3()" onmouseover="menulist()" onmouseout="hidemenu()" >学生管理</a></strong></td>
    	</tr>
    	<tr>
    		<td><img src="../image/notebook.jpg" width="67" height="78"></img></td>
    		<td>&nbsp;&nbsp;&nbsp;&nbsp;<font size="3"><strong><a href="visitor.jsp" target="right" onclick="openl4()">来访登记</a></strong></font></td>
    	</tr>
    	<tr>
    		<td><font size="3"><img height="78" width="67" src="../image/clothes.jpg"></font></td>
    		<td><font size="3">&nbsp;&nbsp;&nbsp;&nbsp;<strong><a href="changedorm.jsp" target="right" onclick="openl5()">宿舍变更</a></strong></font></td>
    	</tr>
    </table>
    </div>
    <div id="menu" style="display:none; background-color:white; position:absolute; top:200; left:205; height:70; width:45;" onmouseover="menulist()" onmouseout="hidemenu()">
    	<table>
    		<tr><td>&nbsp;&nbsp;&nbsp;<a href="../StuServlet?action=select" target="right"><img src="../image/look.jpg" width="30" height="30"></img></a></td></tr>
    		<tr><td>&nbsp;&nbsp;&nbsp;<a href="../StuServlet?action=newstu" target="right"><img src="../image/newstu.jpg" width="30" height="30"></img></a></td></tr>
    	</table>
    </div>
</body>
</html>
