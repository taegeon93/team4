<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>errorPage</title>
</head>
<body>
<%@ include file="menubar.jsp" %>
	<h1 align="center">에러페이지<%= request.getAttribute("errorMsg") %></h1>

</body>
</html>