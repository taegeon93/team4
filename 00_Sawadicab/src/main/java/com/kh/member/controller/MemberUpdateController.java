package com.kh.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect(request.getContextPath()+ "/myPage.me");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 인코딩 설정 (POST 요청)
		request.setCharacterEncoding("UTF-8");
		// 2) 전달된 데이터를 뽑아오기. 로그인한 유저 정보 뽑아오기.
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String phone = request.getParameter("phone");
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		
		
			// 3) Member 객체를 생성하여 서비스에게 전달
			Member updateMember = new Member(memberId,memberPwd, memberName,birthDate,
			phone);

			// --- 요청 처리
			Member member = new MemberService().updateMemer(updateMember);
			
			// 회원 정보 변경 실패 => member 의 값이 null
		
			if (member == null ) {
			// 에러메세지와 함께 에러페이지를 응답
			request.setAttribute("errorMsg", "회원 정보 변경 실패!");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			} else {
			// 회원 정보 변경 성공 => member의 값이 변경된 정보 => session에 변경된 정보로 업데이트
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);	
			session.setAttribute("alertMsg", "회원 정보 변경 성공!");
			
			// 마이 페이지로 url 재요청
			response.sendRedirect(request.getContextPath() + "/myPage.me"); // "/jsp/myPage.me" url 재요청
			}
	}
}
				
	

