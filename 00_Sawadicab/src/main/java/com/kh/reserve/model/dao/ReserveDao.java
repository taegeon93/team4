package com.kh.reserve.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.company.model.vo.Company;
import com.kh.member.model.vo.Member;
import com.kh.reserve.model.dto.ReserveDto;
import com.kh.reserve.model.vo.Review;
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

	public ArrayList<Company> searchCompany(Connection conn, ReserveDto rs) {
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
								rset.getInt("reserve_num"),
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

	public int deleteReserve(Connection conn, String userId, String userPwd, int reserveNum) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteReserve");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, reserveNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Review> selectReview(Connection conn, int companyNum) {
		ArrayList<Review> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, companyNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(
							new Review(
										rset.getString("member_name"),
										rset.getString("review_info"),
										rset.getInt("score"),
										rset.getDate("write_day")
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

	public int insertReserve(Connection conn, Date checkIn, Date checkOut,int roomNum, Company c, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReserve");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setInt(2, roomNum);
			pstmt.setDate(3, checkIn);
			pstmt.setDate(4, checkOut);
			pstmt.setString(5,c.getCompanyAddress());
			pstmt.setString(6,c.getCompanyName());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
				
		
		return result;
	}

	
	public int selectCompanyNum(Connection conn, int reserveNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectCompanyNum");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reserveNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReview(Connection conn, Review review) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertReview");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, review.getReserveNum());
			pstmt.setString(2, review.getMemberId());
			pstmt.setInt(3, review.getCompanyNum());
			pstmt.setString(4, review.getReviewInfo());
			pstmt.setInt(5, review.getScore());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
