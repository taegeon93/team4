package com.kh.company.service;

import com.kh.company.model.dao.CompanyDao;
import com.kh.company.model.vo.Company;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

public class CompanyService {

	public Company selectCompany(int companyNum) {
		Connection conn = getConnection();
		
		
		Company c = new CompanyDao().selectCompany(conn,companyNum);
		
		
		close(conn);
		
		return c;
	}


}
