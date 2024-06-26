package com.kh.reserve.model.vo;

import java.sql.Date;

public class Reserve {
	private int reserveNum;
	private String memberId;
	private int roomNum;
	private Date checkIn;
	private Date checkOut;
	private String companyAddress;
	private String companyName;
	
	
	
	public Reserve() {
		super();
	}
	
	


	public Reserve(int reserveNum, Date checkIn, Date checkOut, String companyAddress, String companyName) {
		super();
		this.reserveNum = reserveNum;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.companyAddress = companyAddress;
		this.companyName = companyName;
	}




	public int getReserveNum() {
		return reserveNum;
	}



	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}



	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public int getRoomNum() {
		return roomNum;
	}



	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}



	public Date getCheckIn() {
		return checkIn;
	}



	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}



	public Date getCheckOut() {
		return checkOut;
	}



	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}



	public String getCompanyAddress() {
		return companyAddress;
	}



	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	@Override
	public String toString() {
		return "Reserve [reserveNum=" + reserveNum + ", memberId=" + memberId + ", roomNum=" + roomNum + ", checkIn="
				+ checkIn + ", checkOut=" + checkOut + ", companyAddress=" + companyAddress + ", companyName="
				+ companyName + "]";
	}
	
	
}
