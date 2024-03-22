<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <img src="<%=request.getContextPath() %>/resources/img/company/1/신라.webp" alt="">
            </div>
        </div>
        <p class="fontsty">라한셀렉트 경주</p><br>

        <div class="area2">

            <div class="wrapper">
                <i id="left" class="fa-solid fa-angle-left"></i>
                <div class="carousel">
                    <div>
                        
                        <p>asdasdssss</p>
                    </div>
                    <div>
                        
                        <p>asdasd</p>
                    </div>
                    <div>
                        <p>asdasd</p>
                    </div>
                    <div>
                        <p>asdasd</p>
                    </div>
                    <div>
                        <p>asdasd</p>
                    </div>
                    <div>
                        <p>asdasd</p>
                    </div>
                    <div>
                        <p>asdasd</p>
                    </div>
                    <div>
                        <p>asdasd</p>
                    </div>
                    <div>
                        <p>asdasd</p>
                    </div>
                </div>
                <i id="right" class="fa-solid fa-angle-right"></i>
            </div>

            <div class="map-area">
                <img src="<%=request.getContextPath()%>/resources/img/common/map.jpg" alt="지도">
                <p>종로3가역 1번출구</p>
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
                <div>
                    <div class="itemimg"><img src="./img/img-3.jpg" alt=""></div>
                    <p>디럭스 더블</p>
                    <div class="iteminfo">
                        <p>가격:340,000원/1박</p>
                        <button class="btn btn-primary">예약</button>
                    </div>
                </div>
                <hr>
                <div>
                    <div class="itemimg"><img src="./img/img-5.jpg" alt=""></div>
                    <p>스탠다드</p>
                    <div class="iteminfo">
                        <p>가격:270,000원/1박</p>
                        <button class="btn btn-secondary" onclick="false">예약불가</button>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </main>

</body>
</html>