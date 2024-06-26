package com.kh.company.model.dto;

public class MainCompanyDto {
	
	private int companyNum;
	private String companyName;
	private String companypicture;
	private double score;
	private String companyAddress;
	
	
	public MainCompanyDto() {
		super();
	}

	public MainCompanyDto(int companyNum, String companyName, String companypicture, double score,
			String companyAddress) {
		super();
		this.companyNum = companyNum;
		this.companyName = companyName;
		this.companypicture = companypicture;
		this.score = score;
		this.companyAddress = companyAddress;
	}

	public int getCompanyNum() {
		return companyNum;
	}
	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanypicture() {
		return companypicture;
	}
	public void setCompanypicture(String companypicture) {
		this.companypicture = companypicture;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Override
	public String toString() {
		return "MainCompanyDto [companyNum=" + companyNum + ", companyName=" + companyName + ", companypicture="
				+ companypicture + ", score=" + score + ", companyAddress=" + companyAddress + "]";
	}


	
	
}
