<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<% 
	Member loginUser = (Member)session.getAttribute("loginUser");
	String alertMsg = (String)session.getAttribute("alertMsg");
	String serchVal = (String)session.getAttribute("serchVal");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
<%if(alertMsg !=null){ %>
<script>
		alert("<%=alertMsg %>");		
	</script>
		<%session.removeAttribute("alertMsg"); %>
<%} %>
    <header>
        <div class="hstyle">
            <a href="<%=request.getContextPath() %>"><img src="<%=request.getContextPath() %>/resources/img/common/logo.png" alt="이미지"></a>
            <%if(serchVal != null){ %>
            <div class="mparea">
              <form action="" method="get">
                <div class="searchgroup">
                  <div class="search1">
                    <img src="<%=request.getContextPath() %>/resources/img/common/airplane.png" alt="airplane">
                    <input type="text" name="" id="" placeholder="여행지를 검색하세요." required>
                  </div>
                  <div class="search2">
                    <img src="<%=request.getContextPath() %>/resources/img/common/calendar.png" alt="calendar">
                    <input type="date" name="" id=""  min="" required>~
                    <input type="date" name="" id="" min="" required>
                  </div>
                  <button type="submit" class="btn btn-primary">검색</button>
                </div>
              </form>
            </div>
            <%} %>
            
            <%if(loginUser == null){ %>
            <button class="btn btn-primary" onclick="goLogin()">로그인</button>
            <%}else{ %>
                <div id="loginSuccess">
                    <button class="btn btn-outline-secondary" onclick="goMyPage()">MyPage</button>
                    <a id="logout" href="<%=request.getContextPath()%>/logout.me"><button class="btn btn-danger">Logout</button></a>
                </div>
            <%} %>
            
        </div>
        <hr>
    </header>
  	<script>
  		function goLogin(){
	  	    
	  	    location.href ="<%=request.getContextPath() %>/loginpage.move";
  		}
  		function goMyPage() {
  			location.href = "<%= request.getContextPath() %>/myPage.me";
  		}
  	</script>

</body>
</html>