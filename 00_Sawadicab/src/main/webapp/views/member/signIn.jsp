<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/signin.css">
</head>
<body>
<%@include file="../common/menubar.jsp" %>
    <div class="member">
        <fieldset>
            <form action="<%=request.getContextPath() %>/signIn.me" method="post" id="scale-box">
                <label><h5><strong>회원가입</strong></h5></label><br>
                <div id="div1">
                    <input type="text" name="userId" placeholder="아이디" required/><br>
                    <input type="password" name="userPwd" id="userPwd" placeholder="비밀번호" required/><br>
                    <input type="password" name="userPwdCheck" id="userPwdCheck" placeholder="비밀번호확인" required/><br>
                    <input type="text" name="userName" placeholder="이름" required/><br>
                    <input type="date" name="birthDate" placeholder="생년월일" required/><br>
                    <input type="text" name="phone" placeholder="전화번호" required/>
                </div>
                <div>
                    <button type="submit" onclick="return signIn()" class="btn btn-primary btn1">회원가입</button><br>
                    <button class="btn btn-success btn1">네이버로 시작하기</button><br>
                    <button class="btn btn-warning btn1">카카오로 시작하기</button>
                </div>
            </form>
        </fieldset>
        </form>
    </div>
<script>
    function signIn() {
        const userPwd = document.getElementById("userPwd");
        const userPwdCheck = document.getElementById("userPwdCheck");
        const regExp = /^[a-zA-Z0-9`~!@#$%^&*]{4,16}$/

        console.log(userPwd.value);
        console.log(userPwdCheck.value);

        if (regExp.test(userPwd.value)) {
            if (userPwd.value != userPwdCheck.value) {
                alert("비밀번호가 일치하지 않습니다.");
                return false;
            } else {
                return true;
            }
        } else {
            alert("비밀번호를 4 ~ 16자 사이로 입력해 주세요.")
            return false;
        }
    }
</script>
</body>
</html>