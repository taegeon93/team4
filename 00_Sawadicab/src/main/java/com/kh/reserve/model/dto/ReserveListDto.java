package com.kh.reserve.model.dto;

import java.sql.Date;

public class ReserveListDto {
	private int companyNum;
	private String companyPicture;
	private Date checkIn;
	private Date checkOut;
	private String companyName;
	private String companyAddress;
	private int reserveNum;
	
	public ReserveListDto() {
		super();
	}

	public ReserveListDto(int companyNum, String companyPicture, Date checkIn, Date checkOut, String companyName,
			String companyAddress, int reserveNum) {
		super();
		this.companyNum = companyNum;
		this.companyPicture = companyPicture;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.reserveNum = reserveNum;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public int getReserveNum() {
		return reserveNum;
	}

	public void setReserveNum(int reserveNum) {
		this.reserveNum = reserveNum;
	}

	@Override
	public String toString() {
		return "ReserveListDto [companyNum=" + companyNum + ", companyPicture=" + companyPicture + ", checkIn="
				+ checkIn + ", checkOut=" + checkOut + ", companyName=" + companyName + ", companyAddress="
				+ companyAddress + ", reserveNum=" + reserveNum + "]";
	}
}
