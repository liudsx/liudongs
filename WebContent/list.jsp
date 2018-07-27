<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>头像</td>
			<td>用户ID</td>
			<td>上传人</td>
			<td>原始文件名</td>
			<!--<td>文件存储路径</td>  -->
			<td>新文件名</td>
		</tr>
		<c:forEach items="${list }" var="ui">
			<td><img src="savefile/${ui.imbm}" style="width:100px;height:100px"></td>
			<td>${ui.usid }</td>
			<td>${ui.uname }</td>
			<td>${ui.imname }</td>
			<!-- <td>${ui.impath }</td> -->
			<td>${ui.imbm }</td>
			<td><a href="savefile/${ui.imbm}">下载一(右键另存为)</a>
		<br>
		
		<a href="uploadfile.sw?name=${ui.imname}&bm=${ui.imbm}">下载二</a>
		</td>
			</c:forEach>
	
	</table>
</body>
</html>