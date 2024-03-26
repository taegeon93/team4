<%@page import="java.text.DecimalFormat"%>
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
	DecimalFormat format = new DecimalFormat("###,###,###");
	Date checkIn = (Date)request.getAttribute("checkIn");
	Date checkOut = (Date)request.getAttribute("checkOut");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/detail.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<script src="<%=request.getContextPath()%>/resources/script/detail.js" defer></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b4094dce76d0e54051b24add9a176af1&libraries=services"></script>
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

            <div class="map-area" >
            <div id="map" style="width:500px;height:400px;"></div>
               <!-- <img src="<%=request.getContextPath()%>/resources/img/common/map.jpg" alt="지도"> --> 
                <p id="address"><%=c.getCompanyAddress() %></p>
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
	                <div class="roomNum" id="<%= r.getRoomNum() %>">
                        <input type="hidden" id="checkIn" value="<%=checkIn%>"/>
                         <input type="hidden" id="checkOut" value="<%=checkOut%>"/>
                         <input type="hidden" style="" id="roomNum" value="<%=r.getRoomNum()%>"/>
	                    <div class="itemimg"><img src="<%=request.getContextPath()%>/resources/img/company/<%=r.getCompanyNo() %>/<%=r.getRoomPicthre() %>" alt=""></div>
	                    <p>
		                    <%=r.getRoomName() %>
		                    <br><br><br>
		                    <span style="font-size: 15px;">체크인 : <%=r.getCheckTimeIn() %></span><br>
		                    <span style="font-size: 15px;">체크아웃 : <%=r.getCheckTimeOut() %></span>
	                    </p>
	                    <div class="iteminfo">
	                        <p><%=format.format(r.getPrice()) %>원/1박</p>
	                        <button class="reserveBtn btn btn-primary">예약</button>
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
    <script>
    var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    var options = { //지도를 생성할 때 필요한 기본 옵션
    	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
    	level: 3 //지도의 레벨(확대, 축소 정도)
    };

    var map = new kakao.maps.Map(container, options);
    function getPoint(){
    	var geocoder = new kakao.maps.services.Geocoder();

    	// 주소로 좌표를 검색합니다
    	geocoder.addressSearch(document.getElementById("address").innerText, function(result, status) {

    	    // 정상적으로 검색이 완료됐으면 
    	     if (status === kakao.maps.services.Status.OK) {

    	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

    	        // 결과값으로 받은 위치를 마커로 표시합니다
    	        var marker = new kakao.maps.Marker({
    	            map: map,
    	            position: coords
    	        });

    	        // 인포윈도우로 장소에 대한 설명을 표시합니다
    	        var infowindow = new kakao.maps.InfoWindow({
    	            content: '',
    	        });
    	       // infowindow.open(map, marker);

    	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
    	        map.setCenter(coords);
    	    } 
    	});    
    }
    setTimeout(function(){
        getPoint();
    }, 1000);

    onload= function(){
        $('.reserveBtn').click(function(e){
            const roomNum = e.target.closest('.roomNum');
            location.href="<%=request.getContextPath()%>/insertReserve.me?roomNum="+roomNum.id+"&checkIn=<%=checkIn%>&checkOut=<%=checkOut%>"
            
        });
    }
    </script>

</body>
</html>