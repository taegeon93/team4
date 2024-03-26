package com.kh.reserve.model.dto;

import java.sql.Date;

public class ReserveDto {
	private int reserveNum;
	private String memberId;
	private int roomNum;
	private Date checkIn;
	private Date checkOut;
	private String companyAddress;
	private String companyName;
	private int companyNum;
	private String companyPicture;
	
	
	public ReserveDto() {
		super();
	}

	public ReserveDto(int reserveNum, String memberId, int roomNum, Date checkIn, Date checkOut, String companyAddress,
			String companyName, int companyNum, String companyPicture) {
		super();
		this.reserveNum = reserveNum;
		this.memberId = memberId;
		this.roomNum = roomNum;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.companyAddress = companyAddress;
		this.companyName = companyName;
		this.companyNum = companyNum;
		this.companyPicture = companyPicture;
	}
	
	
	
	public ReserveDto(String roomNum, String companyAddress, String companyName) {
		super();
		this.companyAddress = companyAddress;
		this.companyName = companyName;
		this.companyNum = companyNum;
		this.companyPicture = companyPicture;
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

	public int getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}

	public String getCompanyPicture() {
		return companyPicture;
	}

	public void setCompanyPicture(String companyPicture) {
		this.companyPicture = companyPicture;
	}

	@Override
	public String toString() {
		return "Reserve [reserveNum=" + reserveNum + ", memberId=" + memberId + ", roomNum=" + roomNum + ", checkIn="
				+ checkIn + ", checkOut=" + checkOut + ", companyAddress=" + companyAddress + ", companyName="
				+ companyName + ", companyNum=" + companyNum + ", companyPicture=" + companyPicture + "]";
	}


	
	
}
