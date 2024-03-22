package com.kh.room.model.vo;

public class Room {

	private int companyNo;
	private String companyName;
	private int roomNum;
	private int price;
	private String roomName;
	private String checkTimeIn;
	private String checkTimeOut;
	private String roomPicthre;
	private String companyPicthre;
	
	
	
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Room(int companyNo, String companyName, int roomNum, int price, String roomName, String checkTimeIn,
			String checkTimeOut, String roomPicthre, String companyPicthre) {
		super();
		this.companyNo = companyNo;
		this.companyName = companyName;
		this.roomNum = roomNum;
		this.price = price;
		this.roomName = roomName;
		this.checkTimeIn = checkTimeIn;
		this.checkTimeOut = checkTimeOut;
		this.roomPicthre = roomPicthre;
		this.companyPicthre = companyPicthre;
	}


	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getCheckTimeIn() {
		return checkTimeIn;
	}
	public void setCheckTimeIn(String checkTimeIn) {
		this.checkTimeIn = checkTimeIn;
	}
	public String getCheckTimeOut() {
		return checkTimeOut;
	}
	public void setCheckTimeOut(String checkTimeOut) {
		this.checkTimeOut = checkTimeOut;
	}
	public String getRoomPicthre() {
		return roomPicthre;
	}
	public void setRoomPicthre(String roomPicthre) {
		this.roomPicthre = roomPicthre;
	}
	public String getCompanyPicthre() {
		return companyPicthre;
	}
	public void setCompanyPicthre(String companyPicthre) {
		this.companyPicthre = companyPicthre;
	}
	@Override
	public String toString() {
		return "Room [companyNo=" + companyNo + ", companyName=" + companyName + ", roomNum=" + roomNum + ", price="
				+ price + ", roomName=" + roomName + ", checkTimeIn=" + checkTimeIn + ", checkTimeOut=" + checkTimeOut
				+ ", roomPicthre=" + roomPicthre + ", companyPicthre=" + companyPicthre + "]";
	}
	
	
}
