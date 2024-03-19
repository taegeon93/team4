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
                <br><br>
                <button id="modify-btn" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteUserModal">회원탈퇴</button>
            </div>
        </div>
		<div class="modal fade" id="deleteUserModal">
		<div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="exampleModalLabel">회원 탈퇴</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body" align="center">
			        <form action="<%= request.getContextPath() %>/delete.me" method="post">
			        	<b>
			        		탈퇴 후 복구가 불가능합니다.<br>
			        		정말로 탈퇴하시겠습니까?
			        	</b>
			        	<br><br>
			        	<input type="hidden" name="userId" value ="<%= loginUser.getMemberId() %>" /> 
			        	비밀번호 : <input type="password" name="userPwd" />
			        	<br><br>
			        	 <button type="submit" class="btn btn-sm btn-danger">회원탈퇴</button>
			        </form>
			      </div>
  				</div>
  			</div>
  		</div>
	</main>
</body>

</html>