<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>
<%
	Member m = (Member)request.getAttribute("member");
    
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Project</title>
<link rel="stylesheet" href="../../resources/css/Update.css">
</head>
<body>
    <%@include file="../common/menubar.jsp" %>
    <main>
    <%@include file="../common/sidebar.jsp" %>
    <form action="<%= request.getContextPath() %>/update.me" method="post">
    <div class="mypage-updatearea">
        <p>개인정보 수정하기</p>
            <img src="<%=request.getContextPath() %>/resources/img/common/user.webp" id="profil-image" alt="프로필이미지">
            <input type="text" class="mypage-detail" name="memberId" value="<%=loginUser.getMemberId() %>" readonly></input>
            <input type="text" class="mypage-detail" name="memberName" value="<%=loginUser.getMemberName() %>" readonly></input>
            <input type="password" class="mypage-detail2" name="memberPwd" value="" placeholder="비밀번호"></input>
            <input type="password" class="mypage-detail2" name="memberPwdCheck" value="" placeholder="비밀번호확인"></input>
            <input type="text" class="mypage-detail2" name="phone" value="<%=loginUser.getPhone() %>" ></input>
            <input type="text" class="mypage-detail" name="birthDate" value="<%=loginUser.getBirthDate() %>" readonly></input>
            <div class="btn-updatearea">
                    <button type="submit" class="btn btn-secondary"  onclick="return checkPwd()" >수정하기</button>
                    <br><br>
                    <button type="button" class="btn btn-danger" onclick="history.back()">뒤로가기</button>
            </div>
        </form>
        	<script>
		function checkPwd(){
			// 비밀번호, 비밀번호 확인 요소 접근해서 값을 꺼내온 뒤
			let memberPwd = document.querySelector("form input[name=memberPwd]");
			let memberPwdCheck = document.querySelector("form input[name=memberPwdCheck]");
			
			
			// 다른 경우 false를 리턴
			if (memberPwd.value != memberPwdCheck.value){
				alert("비밀번호가 다릅니다. 확인 후 다시 입력해주세요.");
				return false;
			}
		}
	</script>
        
    </div>
    </main>
</body>
</html>
