package com.kh.company.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.company.model.dao.CompanyDao;
import com.kh.company.model.dto.MainCompanyDto;
import com.kh.company.model.vo.Company;

public class CompanyService {

	public Company selectCompany(int companyNum) {
		Connection conn = getConnection();
		
		
		Company c = new CompanyDao().selectCompany(conn,companyNum);
		
		
		close(conn);
		
		return c;
	}

	public ArrayList<MainCompanyDto> selectMainCompany() {
		Connection conn = getConnection();
		
		ArrayList<MainCompanyDto> list = new ArrayList<>();
		
		list = new CompanyDao().selectMainCompany(conn);
		
		close(conn);
		
		
		return list;
	}

	public Company detailCompanySelect(int roomNum) {
		
		Connection conn = getConnection();
		Company c = new CompanyDao().detailCompanySelect(conn,roomNum);
		
		close(conn);
		
		return c;
	}


}
