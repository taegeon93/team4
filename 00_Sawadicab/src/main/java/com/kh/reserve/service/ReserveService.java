package com.kh.reserve.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.reserve.model.dao.ReserveDao;
import com.kh.reserve.model.vo.Reserve;


public class ReserveService {

	public ArrayList<Reserve> searchCompany(Reserve rs) {
		ArrayList<Reserve> list = new ArrayList<>();
		
		Connection conn = getConnection();
		
		list = new ReserveDao().searchCompany(conn, rs);
		
		return list;
	}


}
