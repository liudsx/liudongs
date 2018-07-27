<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>~~~~哈哈哈， 你出现异常了！~~~~</h1>
	<br>
	<h1>异常信息：</h1>
	<br>
	<%
		Exception e = (Exception) request.getAttribute("ex");
		out.println(e.getMessage());
	%>
	<br>
	<h1>产生异常的名称；</h1>
	<%=e.getClass().getSimpleName()%>

	<%
		e.printStackTrace();
	%>
</body>
</html>