<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<<<<<< HEAD
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지 - 여기어떤데</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/sidebar.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/myPage.css">
</head>

<body>

    <header>
        <div class="hstyle">
            <a href="main.html"><img src="<%=request.getContextPath() %>/resources/img/common/logo.png" alt="이미지"></a>
            <button class="btn btn-outline-secondary">MyPage</button>
        </div>
        <hr>
    </header>
    <main>
        <nav class="sidebar">
            <div class="sidebar-link">
                <a href="myPage.html"><div>회원정보</div></a>
            </div>
            <div class="sidebar-link">
                <a href="reservePage.html"><div>예약내역</div></a>
            </div>
            <div class="sidebar-link">
                <a href="modify.html"><div>개인정보 수정</div></a>
            </div>
        </nav>
        <div class="mypage-area">
            <p>마이페이지</p>
            <img src="<%=request.getContextPath() %>/resources/img/mypageimg/profileimage.webp" id="profil-image" alt="프로필이미지">
            <input type="text" class="mypage-detail" name="userId" value="아이디" readonly></input>
            <input type="text" class="mypage-detail" name="userName" value="이름" readonly></input>
            <input type="text" class="mypage-detail" name="userPhone" value="전화번호" readonly></input>
            <input type="text" class="mypage-detail" name="userBirthday" value="생일" readonly></input>
            <div class="btn-area">
                <button id="modify-btn" class="btn btn-secondary" >회원정보수정</button>
            </div>
        </div>
    </main>
</body>

=======
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
>>>>>>> 0ecb24aa485bfad62175d2a38f2961b2b5d944b1
</html>