<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/myPage.css">
</head>
<body>
	<%@include file="../common/menubar.jsp" %>
	<main>
	<%@include file="../common/sidebar.jsp" %>
		<div class="mypage-area">
            <p>마이페이지</p>
            <img src="<%=request.getContextPath() %>/resources/img/common/user.webp" id="profil-image" alt="프로필이미지">
            <input type="text" class="mypage-detail" name="userId" value="<%=loginUser.getMemberId() %>" readonly></input>
            <input type="text" class="mypage-detail" name="userName" value="<%=loginUser.getMemberName() %>" readonly></input>
            <input type="text" class="mypage-detail" name="userPhone" value="<%=loginUser.getPhone() %>" readonly></input>
            <input type="text" class="mypage-detail" name="userBirthday" value="<%=loginUser.getBirthDate() %>" readonly></input>
            <div class="btn-area">
                <button id="modify-btn" class="btn btn-secondary" >회원정보수정</button>
                <button id="modify-btn" class="btn btn-danger" >회원탈퇴</button>
            </div>
        </div>
	
	</main>

</body>

</html>