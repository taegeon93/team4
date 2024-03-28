package com.kh.reserve.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.company.model.vo.Company;
import com.kh.member.model.vo.Member;
import com.kh.reserve.model.dao.ReserveDao;
import com.kh.reserve.model.dto.ReserveDto;
import com.kh.reserve.model.dto.ReserveListDto;
import com.kh.reserve.model.vo.Reserve;
import com.kh.reserve.model.vo.Review;

public class ReserveService {

	public ArrayList<Company> searchCompany(ReserveDto rs) {
		ArrayList<Company> list = new ArrayList<>();
		
		Connection conn = getConnection();
		list = new ReserveDao().searchCompany(conn, rs);
		close(conn);
		return list;
	}

	public ArrayList<ReserveListDto> selectReserveList(String memberId) {
		ArrayList<ReserveListDto> list = new ArrayList<>();
		Connection conn = getConnection();
		list = new ReserveDao().selectReserveList(conn, memberId);
		close(conn);
		return list;
	}

	public int deleteReserve(String userId, String userPwd, int reserveNum) {
		int result = 0;
		Connection conn = getConnection();
		result = new ReserveDao().deleteReserve(conn, userId, userPwd, reserveNum);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Review> selectReview(int companyNum) {
		ArrayList<Review> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = new ReserveDao().selectReview(conn, companyNum);
		close(conn);
		
		return list;
	}

	public int insertReivew(Review review) {
		int result = 0;
		Connection conn = getConnection();
		// COMPANY_NUM 조회
		int companyNum = new ReserveDao().selectCompanyNum(conn, review.getReserveNum());
		
		if (companyNum > 0) {
			review.setCompanyNum(companyNum);
			result = new ReserveDao().insertReview(conn, review);
		}
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int insertReserve(int roomNum, Date checkIn, Date checkOut,Company c, Member m) {
		
		Connection conn = getConnection();
		int result = new ReserveDao().insertReserve(conn,checkIn,checkOut,roomNum,c,m);
		if(result >0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}



	


}
