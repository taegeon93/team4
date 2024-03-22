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
			pstmt.setString(1, rs.getCompanyName());
			pstmt.setString(2, rs.getCompanyName());
			pstmt.setDate(3, rs.getCheckIn());
			pstmt.setDate(4, rs.getCheckOut());
			pstmt.setDate(5, rs.getCheckIn());
			pstmt.setDate(6, rs.getCheckOut());
			pstmt.setDate(7, rs.getCheckIn());
			pstmt.setDate(8, rs.getCheckOut());
			
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

	public ArrayList<Reserve> selectReserveList(Connection conn, String memberId) {
		ArrayList<Reserve> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReserveList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(
						new Reserve(
								rset.getInt("reserveNum"),
								rset.getDate("checkIn"),
								rset.getDate("checkOut"),
								rset.getString("company_name"),
								rset.getString("company_address")
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

	public int deleteReserve(Connection conn, String userId, String userPwd) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReserve");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
