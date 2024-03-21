<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.reserve.model.vo.Reserve"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<Reserve> list = (ArrayList<Reserve>)request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/list.css">
</head>
<body>
<%@include file="../common/menubar.jsp" %>
<main>
      <div class="sidebar">
        <div class="sidebar-link">
          <input type="radio" value="호텔" name="category"><label>호텔</label>
        </div>
        <div class="sidebar-link">
           <input type="radio" value="모텔" name="category"><label>모텔</label>
        </div>
        <div class="sidebar-link">
            <input type="radio" value="펜션" name="category"><label>펜션</label>
        </div>
        <div class="sidebar-link">
            <input type="radio" value="게스트하우스" name="category"><label>게스트하우스</label>
        </div>
      </div>
      <section id="mainSection">
        <div class="item">
          <img src="../taegeon/24_03_04/img/라한.webp" alt="test">
          <div class="item_name">
              <span class="companyName">노보텍 앰배서더 동대문호텔</span>
              <span class="companyAddress">중구 동대문 역사문화공원</span>
              <span class="score">별점</span>
          </div>
          <div class="item_price"><button class="btn btn-danger" >예약불가</button></div>
        </div>
        <div class="item">
          <img src="../taegeon/24_03_04/img/라한.webp" alt="test">
          <div class="item_name">
              <span class="companyName">노보텍 앰배서더 동대문호텔</span>
              <span class="companyAddress">중구 동대문 역사문화공원</span>
              <span class="score">별점</span>
          </div>
          <div class="item_price"><button class="btn btn-primary" >예약</button></div>
        </div>

      </section>
      <%-- 테스트 --%>
      <div>
      	<% for(Reserve r : list) { %>
      	<h5><%= r.getCompanyName() %></h5>
      	<h4><%= r.getCompanyAddress() %></h4>
      	<h3><%= r.getCompanyPicture() %></h3>
      	<h2><%= r.getCompanyNum() %></h2>
      	<% } %>
      </div>
      
    </main>

</body>
</html>