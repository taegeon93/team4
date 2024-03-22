package com.kh.room.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

import com.kh.reserve.model.dao.ReserveDao;
import com.kh.room.model.vo.Room;

public class RoomDao {
private Properties prop = new Properties();
	
	public RoomDao() {
		try {
			prop.loadFromXML(new FileInputStream(ReserveDao.class.getResource("/db/sql/reserve-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Room> selectRoom(int companyNum, Date checkIN, Date checkOut,Connection conn) {
		ArrayList<Room> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		String sql = prop.getProperty("selectRoom");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, checkIN);
			pstmt.setDate(2, checkOut);
			pstmt.setDate(3, checkIN);
			pstmt.setDate(4, checkOut);
			pstmt.setDate(5, checkIN);
			pstmt.setDate(6, checkOut);
			pstmt.setInt(7, companyNum);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				 list.add( new Room(
						rset.getInt("company_num"),
						rset.getString("company_name"),
						rset.getInt("room_num"),
						rset.getInt("price"),
						rset.getString("room_name"),
						rset.getString("checkTimein"),
						rset.getString("checkTimeOut"),
						rset.getString("room_picture"),
						rset.getString("company_picture")						
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

}
