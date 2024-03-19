package com.kh.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberSignInController
 */
@WebServlet("/signIn.me")
public class MemberSignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSignInController() {
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
		String userName = request.getParameter("userName");
		Date birthDate = Date.valueOf(request.getParameter("birthDate"));
		String phone = request.getParameter("phone");
		
		Member m = new Member(userId, userPwd, userName, birthDate, phone);
		
		int result = new MemberService().insertMember(m);
		
		if (result > 0) {
			request.getSession().setAttribute("alertMsg", "회원가입에 성공하였습니다.");
			response.sendRedirect(request.getContextPath() + "/loginpage.move");
		} else {
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
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
