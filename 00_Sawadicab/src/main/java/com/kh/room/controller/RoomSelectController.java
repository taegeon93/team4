package com.kh.room.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.company.model.vo.Company;
import com.kh.company.service.CompanyService;
import com.kh.room.model.vo.Room;
import com.kh.room.service.RoomService;

/**
 * Servlet implementation class RoomSelectController
 */
@WebServlet("/detail.me")
public class RoomSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int companyNum = Integer.parseInt(request.getParameter("companyNum"));
		Date checkIN = Date.valueOf(request.getParameter("checkin"));
		Date checkOut= Date.valueOf(request.getParameter("checkout"));
		
		
		ArrayList<Room> list = new RoomService().selectRoom(companyNum,checkIN,checkOut);
		Company c = new CompanyService().selectCompany(companyNum);
		
		
		
		request.setAttribute("company", c);
		request.setAttribute("rList", list);
		
		request.getRequestDispatcher("views/room/detail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
