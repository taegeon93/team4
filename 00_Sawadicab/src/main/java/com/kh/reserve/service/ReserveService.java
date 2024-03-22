package com.kh.reserve.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.reserve.model.dao.ReserveDao;
import com.kh.reserve.model.vo.Reserve;


public class ReserveService {

	public ArrayList<Reserve> searchCompany(Reserve rs) {
		ArrayList<Reserve> list = new ArrayList<>();
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

	public int deleteReserve(String userId, String userPwd) {
		Connection conn = getConnection();
		int result = new ReserveDao().deleteReserve(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


}
