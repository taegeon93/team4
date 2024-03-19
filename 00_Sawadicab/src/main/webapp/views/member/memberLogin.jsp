<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login.css">
<% String alertMsg = (String)session.getAttribute("alertMsg"); %>
<%if(alertMsg !=null){ %>
<script>
		alert("<%=alertMsg %>");		
	</script>
		<%session.removeAttribute("alertMsg"); %>
<%} %>
</head>
<body>
<%@include file="../common/menubar.jsp" %>
<div class="bsty">
        <div>
            <div>
                <h2>로그인</h2>
                <br>
                <form action="<%=request.getContextPath() %>/login.me" method="post">
                    <input class="sty" type="text" name="userId" id="userId" placeholder="아이디"> <br>
                    <input class="sty" type="password" name="userPwd" id="userPw" placeholder="비밀번호"> <br><br><br>
                    <button type="submit" class="btn btn-primary sty">로그인</button> <br>
                    <button type="button" class="btn btn-success sty">네이버로 로그인</button> <br>
                    <button type="button" class="btn btn-warning sty">카카오로 로그인</button> <br>
                    <button type="button" onclick="signin()" class="btn btn-secondary sty">아직도 회원가입을 하지 않으셨나요?</button>
                </form>
            </div>
        </div>
    </div>
<script>
    function signin() {
        location.href="<%=request.getContextPath() %>/views/member/signIn.jsp"
    }
</script>
</body>

</html>