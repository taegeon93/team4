package com.kh.room.model.vo;

public class Room {
	private int RoomNum;
	private int companyNum;
	private int price;
	private String roomNmae;
	private String checkTimeIn;
	private String dheckTimeOut;
	private String roomInfo;
	private String roomPicture;
	
	public Room(int roomNum, int companyNum, int price, String roomNmae, String checkTimeIn, String dheckTimeOut,
			String roomInfo, String roomPicture) {
		super();
		RoomNum = roomNum;
		this.companyNum = companyNum;
		this.price = price;
		this.roomNmae = roomNmae;
		this.checkTimeIn = checkTimeIn;
		this.dheckTimeOut = dheckTimeOut;
		this.roomInfo = roomInfo;
		this.roomPicture = roomPicture;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRoomNum() {
		return RoomNum;
	}
	public void setRoomNum(int roomNum) {
		RoomNum = roomNum;
	}
	public int getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRoomNmae() {
		return roomNmae;
	}
	public void setRoomNmae(String roomNmae) {
		this.roomNmae = roomNmae;
	}
	public String getCheckTimeIn() {
		return checkTimeIn;
	}
	public void setCheckTimeIn(String checkTimeIn) {
		this.checkTimeIn = checkTimeIn;
	}
	public String getDheckTimeOut() {
		return dheckTimeOut;
	}
	public void setDheckTimeOut(String dheckTimeOut) {
		this.dheckTimeOut = dheckTimeOut;
	}
	public String getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}
	public String getRoomPicture() {
		return roomPicture;
	}
	public void setRoomPicture(String roomPicture) {
		this.roomPicture = roomPicture;
	}
	@Override
	public String toString() {
		return "Room [RoomNum=" + RoomNum + ", companyNum=" + companyNum + ", price=" + price + ", roomNmae=" + roomNmae
				+ ", checkTimeIn=" + checkTimeIn + ", dheckTimeOut=" + dheckTimeOut + ", roomInfo=" + roomInfo
				+ ", roomPicture=" + roomPicture + "]";
	}
	
	
	
}
