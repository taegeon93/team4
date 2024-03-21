package com.kh.reserve.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;

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

	public ArrayList<Reserve> searchCompany(Connection conn, Reserve rs) {
		ArrayList<Reserve> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rs.getCompanyName());
			pstmt.setString(2, rs.getCompanyName());
			pstmt.setDate(3, rs.getCheckIn());
			pstmt.setDate(4, rs.getCheckOut());
			pstmt.setDate(5, rs.getCheckIn());
			pstmt.setDate(6, rs.getCheckOut());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(
							new Reserve(
										rset.getString("company_address"),
										rset.getString("company_name"),
										rset.getInt("company_Num"),
										rset.getString("company_picture")
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
