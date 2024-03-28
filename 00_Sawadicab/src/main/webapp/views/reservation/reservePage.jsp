<%@page import="com.kh.reserve.model.dto.ReserveListDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.reserve.model.vo.Reserve" %>    
<%
	ArrayList<ReserveListDto> list = (ArrayList<ReserveListDto>)request.getAttribute("list");
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약내역 - 여기 어떤데</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/reservePage.css">
</head>

<body>
	<%@include file="../common/menubar.jsp" %>
	<main>
	<%@include file="../common/sidebar.jsp" %>
	<section id="mainSection">
		<% if(list.isEmpty()) {%>
			<h2 align="center">존재하는 예약내역이 없습니다.</h2>
		<% } else { %>
			<% for(ReserveListDto r : list) { %>
				<div class="item">
					<img src="<%= request.getContextPath() %>/resources/img/company/<%= r.getCompanyNum() %>/<%= r.getCompanyPicture() %>" alt="reserveImg">
					<div class="item_name">
						<span class="reserveDate"><%= r.getCheckIn() %> ~ <%= r.getCheckOut() %></span>
						<span class="reserveName"><%= r.getCompanyName() %></span>
						<span class="reserveAddress"><%= r.getCompanyAddress() %></span>
					</div>
			
					<div class="item_price">
					<% if(r.getCheckIn().compareTo(new Date()) > 0 ) { %>
					<button id="cancelBtn" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#reserveCancel" data-reservenum="<%=r.getReserveNum()%>">예약취소</button>
					<% } else {%>
					<button id="reviewBtn" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#reserveReview" data-reservenum="<%=r.getReserveNum()%>">리뷰</button>
					<% } %>
					</div>
					
				</div>
			<% } %>
		<% } %>
	</section>
	</main>
	<div class="modal fade" id="reserveCancel" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
              <!-- 모달 헤더 부분 -->
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">예약취소</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <!-- 모달 바디 부분 -->
            <div class="modal-body" align="center">
              <form action="<%= request.getContextPath() %>/delete.re" method="post">
                  <!-- 아이디 정보 type='hidden' -->
                  <b> 
                     취소하시려면 비밀번호를 입력해주세요.
                  </b>
                  <input type ="hidden" name ="userId" value="<%= loginUser.getMemberId() %>"/>     
                  <input type ="hidden" name ="reserveNum" value = ""/>            
                    <table>
                        <tr>
                            <td>비밀번호</td>
                            <td>
                                <input type="password" name="userPwd"  required />
                            </td>
                        </tr>               
                        
                    </table>
                    <br>
                    <button type="submit" onclick="return checkPassword()"  class="btn btn-warning">예약 취소</button>
              </form>      
              <script>	
              	const checkPassword = () => {
              		if (document.querySelector("input[name=userPwd]").value !== "<%= loginUser.getMemberPwd() %>") {
              			alert("잘못된 패스워드입니다. 다시 입력해주세요.");
              			document.querySelector("input[name=userPwd]").value = '';
              			return false;
              		}
              	}
              </script>
            </div>
           
          </div>
        </div>
      </div>
      <!-------------->
      <div class="modal fade" id="reserveReview" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
              <!-- 모달 헤더 부분 -->
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">리뷰 작성</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" ></button>
            </div>
            <!-- 모달 바디 부분 -->
            <div class="modal-body" align="center">
              <form action="insert.re" method="post" id="myform">
                  <!-- 아이디 정보 type='hidden' -->
                  <input type ="hidden" name ="userId" value="<%= loginUser.getMemberId() %>"/>
                  <input type ="hidden" name ="reserveNum" value = ""/>    
                    <table>
                        <tr>
                            <td>
                                <textarea name="content" cols="40" rows="15" required style="resize: none;"></textarea>
                            </td>
                        </tr>  
                    </table>
                    <fieldset>                    
                        <input type="radio" name="reviewStar" value="5" id="rate1"><label
                            for="rate1">★</label>
                        <input type="radio" name="reviewStar" value="4" id="rate2"><label
                            for="rate2">★</label>
                        <input type="radio" name="reviewStar" value="3" id="rate3"><label
                            for="rate3">★</label>
                        <input type="radio" name="reviewStar" value="2" id="rate4"><label
                            for="rate4">★</label>
                        <input type="radio" name="reviewStar" value="1" id="rate5"><label
                            for="rate5">★</label>
                    </fieldset>
                    <br>
                    <button type="submit"  class="btn btn-warning">작성</button>
                    <button type="reset" class="btn btn-secondary">초기화</button>
              </form>
            </div>           
          </div>
        </div>
      </div>
      <script>
      $(function(){
    	  const cancelModal = document.getElementById('reserveCancel')
	      cancelModal.addEventListener('shown.bs.modal', () => {
	      	const rNum = document.getElementById("cancelBtn").getAttribute("data-reservenum");
	      	document.querySelector("#reserveCancel input[name=reserveNum]").value = rNum;
      	  })
      	  const reviewModal = document.getElementById('reserveReview')
	      reviewModal.addEventListener('shown.bs.modal', () => {
	      	const rNum = document.getElementById("reviewBtn").getAttribute("data-reservenum");
	      	document.querySelector("#reserveReview input[name=reserveNum]").value = rNum;
      	  })
      })
      </script>
</body>
</html>