<%@page import="com.kh.reserve.model.vo.Review"%>
<%@page import="com.kh.company.model.vo.Company"%>
<%@page import="com.kh.room.model.vo.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.room.model.dao.RoomDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	ArrayList<Room> rList = (ArrayList<Room>)request.getAttribute("rList");
	Company c = (Company)request.getAttribute("company");
	ArrayList<Review> rvList = (ArrayList<Review>)request.getAttribute("rvList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<script src="<%=request.getContextPath()%>/resources/script/detail.js" defer></script>
</head>
<body>
<%@include file="../common/menubar.jsp" %>
	<main>
     <div class="area">
            <div>
                <img src="<%=request.getContextPath() %>/resources/img/company/<%=c.getCompanyNum() %>/<%=c.getCompanyPicture() %>" alt="">
            </div>
        </div>
        <p class="fontsty"><%=c.getCompanyName() %></p><br>

        <div class="area2">

            <div class="wrapper">
                <i id="left" class="fa-solid fa-angle-left"></i>
                <div class="carousel">
                	<% for(Review r : rvList) { %>
                    <div style="margin-right: 15px;">
                        <h6><%= r.getMemberId() %></h6>
                        <div>
                            <p style="color: rgb(231, 228, 22);">
                            	<% for(int i = 0; i < r.getScore(); i++) { %>
                            	★
                            	<% } for(int i = 0; i < 5-r.getScore(); i++) { %>
                            	☆
                            	<% } %>
                            </p>
                        </div>
                        <p style="word-wrap: break-word; white-space: break-spaces;"><%=r.getReviewInfo() %></p>
                    </div>
                    <% } %>
                </div>
                <i id="right" class="fa-solid fa-angle-right"></i>
            </div>

            <div class="map-area">
                <img src="<%=request.getContextPath()%>/resources/img/common/map.jpg" alt="지도">
                <p><%=c.getCompanyAddress() %></p>
            </div>
        </div>

        <div class="service-area">
            <p class="fontsty1">서비스 및 부대시설</p>
            <div>
                <img class="service" src="<%=request.getContextPath()%>/resources/img/common/service.png" alt="service">
            </div>
        </div>



        <div class="area3">
            <div class="reserve-area">
               	<% for(Room r : rList) { %>
	                <div>
	                    <div class="itemimg"><img src="<%=request.getContextPath()%>/resources/img/company/<%=r.getCompanyNo() %>/<%=r.getRoomPicthre() %>" alt=""></div>
	                    <p>
		                    <%=r.getRoomName() %>
		                    <br><br><br>
		                    <span style="font-size: 15px;">체크인 : <%=r.getCheckTimeIn() %></span><br>
		                    <span style="font-size: 15px;">체크아웃 : <%=r.getCheckTimeOut() %></span>
	                    </p>
	                    <div class="iteminfo">
	                        <p><%=r.getPrice() %>/1박</p>
	                        <button class="btn btn-primary">예약</button>
	                    </div>
	                </div>
                <hr>
				<% } %>
<!--                 <div> -->
<!--                     <div class="itemimg"><img src="./img/img-5.jpg" alt=""></div> -->
<!--                     <p>스탠다드</p> -->
<!--                     <div class="iteminfo"> -->
<!--                         <p>가격:270,000원/1박</p> -->
<!--                         <button class="btn btn-secondary" onclick="false">예약불가</button> -->
<!--                     </div> -->
<!--                 </div> -->
            </div>
        </div>
        </div>
    </main>

</body>
</html>