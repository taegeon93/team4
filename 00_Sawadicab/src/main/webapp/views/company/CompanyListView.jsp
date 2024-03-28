<%@page import="com.kh.company.model.vo.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<Company> list = (ArrayList<Company>)request.getAttribute("list"); %>
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
      <%if(list.isEmpty()){ %>
      		<h1>선택한 조건에 맞는 상품이 없어요.</h1>
      <%}else{ %>
      		<%for(Company c:list){ %>
	      <div class="item" onclick="location.href='<%=request.getContextPath() %>/detail.me?companyNum=<%=c.getCompanyNum()%>&checkin=<%=date1%>&checkout=<%=date2%>'">
	          <img src="<%=request.getContextPath() %>/resources/img/company/<%=c.getCompanyNum() %>/<%=c.getCompanyPicture() %>" alt="test">
	          <div class="item_name">
	              <span class="companyName"><%=c.getCompanyName() %></span>
	              <span class="companyAddress"><%=c.getCompanyAddress() %></span>
	              <span class="score"> <img src="<%=request.getContextPath() %>/resources/img/common/star.jpg"><%=String.format("%.1f", c.getScore()) %></span>
	          </div>
	          <div class="item_price"></div>
	        </div>
	        <%} %>
       <%} %>

      </section>
    
      
    </main>

</body>
</html>