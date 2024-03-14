<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<% 
	Member loginUser = (Member)session.getAttribute("loginUser");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <header>
        <div class="hstyle">
            <img src="resources/img/logo.png" alt="이미지">
            <%if(loginUser == null){ %>
            <button class="btn btn-primary">로그인</button>
            <%}else{ %>
                <div id="loginSuccess">
                    <button class="btn btn-outline-secondary">MyPage</button>
                    <button class="btn btn-danger">Logout</button>
                </div>
            <%} %>
            
        </div>
        <hr>
    </header>

</body>
</html>