<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'building.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		function mydelete(bid){
			var bid = bid;
			window.location.href="BuildingServlet?action=delete&bid="+bid;
		}
		
		function myupdate(bid,buildingnumber,dormnumber){
			var bid = bid;
			var buidingnumber = buildingnumber;
			var dormnumber = dormnumber;
			document.getElementById("dadd").style.display="block";
			document.getElementById("dclose").style.display="block";
			document.getElementById("layout").style.display="block";
			document.getElementById("1").value=bid;
			document.getElementById("2").value=buildingnumber;
			document.getElementById("3").value=dormnumber;
		}
		function myclose(){
			document.getElementById("dadd").style.display="none";
			document.getElementById("dclose").style.display="none";
			document.getElementById("layout").style.display="none";			
		}
	</script>
  </head>
  
  <body topmargin=0; leftmargin=0;>
  <!-- 添加楼栋 -->
  <div style="position:absolute; left:0; top:50;width:900 ">
  	<table border="1" align="center" width="80%" cellspacing="0">
  		<td colspan="3"><p align="center">添加楼栋</p></td>
  		<form action="BuildingServlet?action=add" method="post">
  			<tr><td>楼栋号<input type="text" name="buildingnumber"/></td>
  			<td>宿舍数量<input type="text" name="dormnumber"/></td>
  			<td><input type="submit" value="添加"/></td></tr>
  		</form>
  		</td>
  	</table>
  </div>
  
  <div style="position:absolute; left:0; top:150;width:900; height:800;">
    <table border="1" align="center" width="80%" cellspacing="0" >
    <td colspan="5"><p align="center">楼栋信息</p></td>
    <tr><td>id</td><td>楼栋号</td><td>宿舍数量</td><td>修改楼栋信息</td><td>删除楼栋</td></tr>
    <c:forEach items="${building}" var="b">
    	<tr>
    		<td>${b.bid}</td>
    		<td>${b.buildingnumber}</td>
    		<td>${b.dormnumber}</td>
    		<td><input type="button" value="修改" onclick="myupdate(${b.bid},'${b.buildingnumber}',${b.dormnumber })"/></td>
    		<td><input type="button" value="删除" onclick="mydelete(${b.bid})"/></td>
    	</tr>
    </c:forEach>
    </table>
  </div>
  <div id="layout" style=" display:none; border: 1px solid ; background: #fff; position: absolute; top: 0px; left: 0px; width: 1500px; height: 700px; opacity: 0.6;"></div>
  <div id="dadd" style="display:none; position:absolute; left:350; top:150; border:double; background-color:white; height:170; width:250; opacity:1;">
  	<form action="BuildingServlet?action=update" method="post">
  		<br>
  		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改楼栋信息</td><br>
  		<br><td><input type="hidden" id="1" name="bid"/></td>
  		<td>&nbsp;&nbsp;楼栋号:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="2" name="buildingnumber"/></td><br>
  		<br>
  		<td>&nbsp;&nbsp;宿舍数量:<input type="text" id="3" name="dormnumber"/></td><br>
  		<td><p align="center"><input type="submit" value="提交"></p></td>
  	</form>
  </div>
		<div id="dclose"
			style="display: none; position: absolute; left: 561; top: 153;">
			<img src="image/closePic.jpg" onclick="myclose()"></img>
		</div>
		<div>
			<img src="image/bg_lotus.jpg" width="1140" height="659"></img>
		</div>
	</body>
</html>
