package com.kh.room.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import static com.kh.common.JDBCTemplate.*;

import com.kh.room.model.dao.RoomDao;
import com.kh.room.model.vo.Room;

public class RoomService {

	public ArrayList<Room> selectRoom(int companyNum, Date checkIN, Date checkOut) {
		ArrayList<Room> list = new ArrayList<>();
		
		Connection conn = getConnection();
		
		list = new RoomDao().selectRoom(companyNum,checkIN,checkOut, conn);
		
		close(conn);
		
		return list;
	}

		
}
