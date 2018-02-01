<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'dorm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		function mydelete(did){
			if(window.confirm("您确定要删除吗?"))
			window.location.href="DormServlet?action=delete&did="+did;
		}
		function mygender(){
			var buildingnumber = document.getElementById("buildingnumber").value;
			if(buildingnumber=="一栋"||buildingnumber=="二栋"||buildingnumber=="五栋")
				document.getElementById("dgender").value="男";
			else if(buildingnumber=="")
				document.getElementById("dgender").value="";
			else{
				document.getElementById("dgender").value="女";
			}
		}
		function myupdate(did,dname,dmaxnum,dactualnum,dtype){
			document.getElementById("did").value=did;
			document.getElementById("dname").value=dname;
			document.getElementById("dmaxnum").value=dmaxnum;
			document.getElementById("dactualnum").value=dactualnum;
			document.getElementById("dtype").value=dtype;
			document.getElementById("dupdate").style.display="block";
			document.getElementById("dclose").style.display="block";
			document.getElementById("layout").style.display="block";
			
		}
		function myclose(){
			document.getElementById("dupdate").style.display="none";
			document.getElementById("dclose").style.display="none";
			document.getElementById("layout").style.display="none";
			
		}
	</script>
  </head>
  
  <body topmargin=0; leftmargin=0;>
    <div style="position:absolute; left:130; top:150;width:900; height:800;">
    	<table border="1" width="80%" cellspacing="0">
    			<tr>
    			<td>楼栋号</td>
    			<td>宿舍名</td>
    			<td>可住人数</td>
    			<td>实住人数</td>
    			<td>宿舍类型</td>
    			<td>性别</td>
    			<td>修改宿舍信息</td>
    			<td>删除宿舍信息</td>
    			</tr>
    	<c:forEach items="${dorm}" var="d">
    		<tr>
    			<td>${d.buildingnumber }</td>
    			<td>${d.dname }</td>
    			<td>${d.dmaxnum }</td>
    			<td>${d.dactualnum }</td>
    			<td>${d.dtype }</td>
    			<td>${d.dgender }</td>
    			<td><input type="button" value="修改" onclick="myupdate(${d.did},${d.dname },${d.dmaxnum },${d.dactualnum },'${d.dtype }')"/></td>
    			<td><input type="button" value="删除" onclick="mydelete(${d.did})"/></td>
    		</tr>
    	</c:forEach>
    	<tr>
    		<td colspan="8" align="center">${pageString }</td>
    	</tr>
    	</table>
    </div>
    <!-- 添加 -->
    <div style="position:absolute; left:130; top:20; width:900;">
    	<table border="1" width="80%" cellspacing="0">
    	<form action="DormServlet?action=add" method="post">
    		<tr><td colspan="3"><p align="center">添加宿舍</p></td></tr>
    		<tr><td>楼栋号&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="buildingnumber" id="buildingnumber" onblur="mygender()"/></td>
	    		<td>宿舍名&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="dname"/></td>
	    		<td>性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" readonly name="dgender" id="dgender"/></td></tr>
    		<tr><td>可住人数<input type="text" name="dmaxnum"/></td>
	    		<td>实住人数<input type="text" name="dactualnum"/></td>
	    		<td>宿舍类型<input type="text" name="dtype"/></td></tr>
	    	<tr><td colspan="3"><p align="center"><input type="submit" value="添加"/></p></td></tr>
    	</form>
    	</table>
    </div>
    <div id="layout" style=" display:none; border: 1px solid ; background: #fff; position: absolute; top: 0px; left: 0px; width: 1500px; height: 700px; opacity: 0.6;"></div>  
    <div id="dupdate" style="display:none;position:absolute; left:320; top:180; border:double; background-color:white;">
    	<table border="1" width="280" height="109" cellspacing="0">
    	<form action="DormServlet?action=update" method="post">
    		<br/>
    		<tr><td><p align="center">修改宿舍</p></td></tr>
    		<input type="hidden" id="did" name="did"/>
    		<tr><td>宿舍名&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="dname" name="dname"/></td></tr>
    		<tr><td>可住人数<input type="text" id="dmaxnum" name="dmaxnum"/></td></tr>
	    	<tr><td>实住人数<input type="text" id="dactualnum" name="dactualnum"/></td></tr>
	    	<tr><td>宿舍类型<input type="text" id="dtype" name="dtype"/></td></tr>
	    	<tr><td colspan="3"><p align="center"><input type="submit" value="修改"/></p></td></tr>
    	</form>
    	</table>
    </div>
  <div id="dclose" style="display:none; position:absolute; left:561; top:184;">
  		<img src="image/closePic.jpg" onclick="myclose()"></img>
  </div>
    <div >
    	<img src="image/bg_lotus.jpg" width="1140" height="659"></img>
    </div>
  </body>
</html>
