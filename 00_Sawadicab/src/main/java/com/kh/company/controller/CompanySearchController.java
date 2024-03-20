package com.kh.company.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.company.model.vo.Company;
import com.kh.company.service.CompanyService;

/**
 * Servlet implementation class CompanySearchController
 */
@WebServlet("/search.co")
public class CompanySearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanySearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchVal = request.getParameter("searchVal");
		String search = request.getParameter("search");
		Date date1 = Date.valueOf(request.getParameter("date1"));
		Date date2 = Date.valueOf(request.getParameter("date2"));
		
		Company c = new Company(search, date1, date2);
		
		Company cp = new CompanyService().selectCompany(c);
		
		request.getSession().setAttribute("searchVal", searchVal);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
