package com.kh.reserve.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.reserve.model.dto.ReserveDto;
import com.kh.reserve.model.vo.Reserve;
import com.kh.reserve.service.ReserveService;

/**
 * Servlet implementation class ReservationPageController
 */
@WebServlet("/reservePage.re")
public class ReservationPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		if(m != null) {
			// 1. 세션에서 로그인한 유저의 member_id 값 꺼내오기
			String memberId = m.getMemberId();
			
			// 2. ReserveService 객체에 member_id 값을 전달해서, 해당 유저의 예약목록 조회해오기
			ArrayList<Reserve> list = new ReserveService().selectReserveList(memberId);
			
			//    조회된 예약목록을 request 객체의 attribute 공간에 저장
			request.setAttribute("list", list);
			// 3. 예약내역 페이지 응답해주기
			request.getRequestDispatcher("views/reservation/reservePage.jsp").forward(request, response);
		} else {
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 페이지입니다.");
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
