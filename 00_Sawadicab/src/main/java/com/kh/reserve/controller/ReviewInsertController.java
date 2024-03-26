package com.kh.reserve.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.reserve.model.vo.Review;
import com.kh.reserve.service.ReserveService;

/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/insert.re")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		int reserveNum = Integer.parseInt(request.getParameter("reserveNum"));
		String content = request.getParameter("content");
		int reviewStar = Integer.parseInt(request.getParameter("reviewStar"));
		
		Review review = new Review();
		review.setMemberId(userId);
		review.setReserveNum(reserveNum);
		review.setReviewInfo(content);
		review.setScore(reviewStar);
		
		int result = new ReserveService().insertReivew(review);
		if(result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "리뷰가 성공적으로 등록되었습니다.");
			response.sendRedirect(request.getContextPath() + "/reservePage.re");
		} else {
			request.setAttribute("errorMsg", "리뷰 등록을 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
