package com.kh.room.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;

import com.kh.room.model.dao.RoomDao;
import com.kh.room.model.dto.RoomDto;

public class RoomService {

	public ArrayList<RoomDto> selectRoom(int companyNum, Date checkIN, Date checkOut) {
		ArrayList<RoomDto> list = new ArrayList<>();
		
		Connection conn = getConnection();
		
		list = new RoomDao().selectRoom(companyNum,checkIN,checkOut, conn);
		
		close(conn);
		
		return list;
	}

		
}
