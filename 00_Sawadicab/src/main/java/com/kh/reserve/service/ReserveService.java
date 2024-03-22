package com.kh.reserve.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.company.model.vo.Company;
import com.kh.reserve.model.dao.ReserveDao;
import com.kh.reserve.model.vo.Reserve;
import com.kh.reserve.model.vo.Review;


public class ReserveService {

	public ArrayList<Company> searchCompany(Reserve rs) {
		ArrayList<Company> list = new ArrayList<>();
		
		Connection conn = getConnection();
		list = new ReserveDao().searchCompany(conn, rs);
		close(conn);
		return list;
	}

	public ArrayList<Reserve> selectReserveList(String memberId) {
		ArrayList<Reserve> list = new ArrayList<>();
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



	


}
