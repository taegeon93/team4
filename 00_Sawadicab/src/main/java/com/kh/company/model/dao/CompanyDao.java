package com.kh.company.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate.*;
import com.kh.company.model.vo.Company;
import com.kh.reserve.model.dao.ReserveDao;

public class CompanyDao {
	
private Properties prop = new Properties();
	
	public CompanyDao() {
		try {
			prop.loadFromXML(new FileInputStream(ReserveDao.class.getResource("/db/sql/company-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Company selectCompany(Connection conn, int companyNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		Company c = null;
		String sql = prop.getProperty("selectCompany");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,companyNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				c.setCompanyNum(rset.getInt("company_num"));
				c.setCompanyName(rset.getString("company_name"));
				c.setCompanyAddress(rset.getString("COMPANY_ADDRESS"));
				c.setCompanyPicture(rset.getString("company_picture"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
				
		return c;
	}

}
