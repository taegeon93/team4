<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainstyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<script src="<%=request.getContextPath() %>/resources/script/script.js" defer></script>
</head>
<body>
<%@include file="views/common/menubar.jsp" %>

<main>
  <div class="backimg">
    <div class="area">
      <form action="<%=request.getContextPath() %>/search.co" method="get">
      	<input type="hidden" name="searchVal" value="1"/>
        <div class="searchgroup">
          <div class="search1">
            <img src="<%=request.getContextPath() %>/resources/mainimg/airplane.png" alt="airplane">
            <input type="text" name="search" id="search" placeholder="여행지를 검색하세요." required>
          </div>
          <div class="search2">
            <img src="<%=request.getContextPath() %>/resources/mainimg/calendar.png" alt="calendar">
            <input type="date" name="date1" id="date1" onchange="date()" min="<%=today %>" required>~
            <input type="date" name="date2" id="date2" required >
          </div>
          <button type="submit" class="btn btn-primary">검색</button>
        </div>
      </form>
    </div>
  </div>
<br><br>
  <div class="area2">
    <h5>인기 추천 숙소</h5><br>
    <div class="wrapper">
        <i id="left" class="fa-solid fa-angle-left"></i>
        <div class="carousel">
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-1.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-2.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-3.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-4.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-5.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-6.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-7.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-8.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
          <div>
            <img src="<%=request.getContextPath() %>/resources/mainimg/img-9.jpg" alt="img" draggable="false">
            <p>asdasd</p>
          </div>
        </div>
        <i id="right" class="fa-solid fa-angle-right"></i>
      </div>

      <h5>국내 인기 여행지</h5><br>
      <div class="best">
        <div style="cursor: pointer;" onclick="location.href='<%=request.getContextPath() %>/search.co?search=제주&date1=<%=today%>&date2=<%=nextDate %>'">
          <img src="<%=request.getContextPath() %>/resources/mainimg/best1.jpg" alt="img">
          <p>제주도</p>
        </div>
        <div style="cursor: pointer;" onclick="location.href='<%=request.getContextPath() %>/search.co?search=서울&date1=<%=today%>&date2=<%=nextDate %>'">
          <img src="<%=request.getContextPath() %>/resources/mainimg/best2.jpg" alt="img">
          <p>서울</p>
        </div>
        <div style="cursor: pointer;" onclick="location.href='<%=request.getContextPath() %>/search.co?search=부산&date1=<%=today%>&date2=<%=nextDate %>'">
          <img src="<%=request.getContextPath() %>/resources/mainimg/best3.jpg" alt="img">
          <p>부산</p>
        </div>
      </div>
      <div class="best">
        <div style="cursor: pointer;" onclick="location.href='<%=request.getContextPath() %>/search.co?search=강릉&date1=<%=today%>&date2=<%=nextDate %>'">
          <img src="<%=request.getContextPath() %>/resources/mainimg/best4.jpg" alt="img">
          <p>강릉</p>
        </div>
        <div style="cursor: pointer;" onclick="location.href='<%=request.getContextPath() %>/search.co?search=인천&date1=<%=today%>&date2=<%=nextDate %>'">
          <img src="<%=request.getContextPath() %>/resources/mainimg/best5.jpg" alt="img">
          <p>인천</p>
        </div>
        <div style="cursor: pointer;" onclick="location.href='<%=request.getContextPath() %>/search.co?search=경주&date1=<%=today%>&date2=<%=nextDate %>'">
          <img src="<%=request.getContextPath() %>/resources/mainimg/best6.jpg" alt="img">
          <p>경주</p>
        </div>
      </div>
      <br><br><br><br>
    </div>
</main>
</body>
</html>