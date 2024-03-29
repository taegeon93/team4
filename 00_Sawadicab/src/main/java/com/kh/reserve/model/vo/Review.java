package com.kh.reserve.model.vo;

import java.sql.Date;

public class Review {
	private int reserveNum;
	private String memberId;
	private int companyNum;
	private String reviewInfo;
	private int score;
	private Date writeDay;
	
	public Review() {
		super();
	}
	
	public Review(String memberId, String reviewInfo, int score, Date writeDay) {
		super();
		this.memberId = memberId;
		this.reviewInfo = reviewInfo;
		this.score = score;
		this.writeDay = writeDay;
	}

	public Review(int reserveNum, String memberId, int companyNum, String reviewInfo, int score, Date writeDay) {
		super();
		this.reserveNum = reserveNum;
		this.memberId = memberId;
		this.companyNum = companyNum;
		this.reviewInfo = reviewInfo;
		this.score = score;
		this.writeDay = writeDay;
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

	public int getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}

	public String getReviewInfo() {
		return reviewInfo;
	}

	public void setReviewInfo(String reviewInfo) {
		this.reviewInfo = reviewInfo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(Date writeDay) {
		this.writeDay = writeDay;
	}

	@Override
	public String toString() {
		return "Review [reserveNum=" + reserveNum + ", memberId=" + memberId + ", companyNum=" + companyNum
				+ ", reviewInfo=" + reviewInfo + ", score=" + score + ", writeDay=" + writeDay + "]";
	}
	
}
