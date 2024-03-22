<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<% 
	Member loginUser = (Member)session.getAttribute("loginUser");
	String alertMsg = (String)session.getAttribute("alertMsg");
	String searchVal = (String)request.getAttribute("searchVal");
	
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String today = dateFormat.format(date);
	
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	cal.add(Calendar.DATE, 1);
	Date nDate = cal.getTime();
	String nextDate = dateFormat.format(nDate);
	
	
	Date date1 = (Date)request.getAttribute("date1");
	Date date2 = (Date)request.getAttribute("date2");
	String search = (String)request.getAttribute("search");
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
<script src="<%=request.getContextPath() %>/resources/script/menubar.js" defer></script>
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
            <%if(searchVal != null){ %>
            <div class="mparea">
              <form action="<%=request.getContextPath() %>/search.co" method="get">
              	<input type="hidden" name="searchVal" value="1"/>
                <div class="searchgroup">
                  <div class="search1">
                    <img src="<%=request.getContextPath() %>/resources/img/common/airplane.png" alt="airplane">
                    <input type="text" name="search" id="search" placeholder="여행지를 검색하세요." value="<%=search %>" required>
                  </div>
                  <div class="search2">
                    <img src="<%=request.getContextPath() %>/resources/img/common/calendar.png" alt="calendar">
                    <input type="date" name="date1" id="date1"  min="<%=today %>" value="<%=date1 %>" onchange="date()" required>~
                    <input type="date" name="date2" id="date2" min="" value="<%=date2 %>" required>
                  </div>
                  <button type="submit" id="search_btn" class="btn btn-primary">검색</button>
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