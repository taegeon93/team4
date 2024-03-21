package com.kh.reserve.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.company.model.vo.Company;
import com.kh.reserve.model.vo.Reserve;

public class ReserveDao {
	private Properties prop = new Properties();
	
	public ReserveDao() {
		try {
			prop.loadFromXML(new FileInputStream(ReserveDao.class.getResource("/db/sql/reserve-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Company> searchCompany(Connection conn, Reserve rs) {
		ArrayList<Company> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, rs.getCheckIn());
			pstmt.setDate(2, rs.getCheckOut());
			pstmt.setDate(3, rs.getCheckIn());
			pstmt.setDate(4, rs.getCheckOut());
			pstmt.setString(5, rs.getCompanyName());
			pstmt.setString(6, rs.getCompanyName());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(
							new Company(
										rset.getInt("company_num"),
										rset.getString("company_name"),
										rset.getString("company_address"),
										rset.getString("company_category"),
										rset.getString("company_picture"),
										rset.getDouble("score")
									)
						);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}

}
