package com.kh.reserve.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.company.model.vo.Company;
import com.kh.company.service.CompanyService;
import com.kh.member.model.vo.Member;
import com.kh.reserve.service.ReserveService;

/**
 * Servlet implementation class ReservationInsert
 */
@WebServlet("/insertReserve.me")
public class ReservationInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomNum = Integer.parseInt(request.getParameter("roomNum"));
		Date checkIn = Date.valueOf(request.getParameter("checkIn"));
		Date checkOut = Date.valueOf(request.getParameter("checkOut"));
		Member m = (Member)request.getSession().getAttribute("loginUser");
		
		if(m == null) {
			request.getSession().setAttribute("alertMsg", "로그인이 필요합니다.");
			response.sendRedirect(request.getContextPath() + "/loginpage.move");
		}else {
			Company c = new CompanyService().detailCompanySelect(roomNum);
			int result = new ReserveService().insertReserve(roomNum,checkIn,checkOut,c,m);
			if(result >0) {
				request.getSession().setAttribute("alertMsg", "예약되었습니다.");
				response.sendRedirect(request.getContextPath());
			}else {
				request.getSession().setAttribute("alertMsg", "다시 시도해주세요.");
				response.sendRedirect(request.getContextPath());
			}
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
