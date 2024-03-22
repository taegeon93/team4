package com.kh.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.reserve.service.ReserveService;

/**
 * Servlet implementation class ReservationDeleteController
 */
@WebServlet("/delete.re")
public class ReservationDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new ReserveService().deleteReserve(userId, userPwd);
		HttpSession session = request.getSession();
		
		if(result > 0) {
			session.setAttribute("alertMsg", "예약이 취소되었습니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			session.setAttribute("alertMsg", "예약 취소에 실패했습니다.");
			response.sendRedirect(request.getContextPath() + "/reservePage.re");
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
