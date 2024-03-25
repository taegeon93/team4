package com.kh.company.model.dto;

public class MainCompanyDto {
	
	private int companyNum;
	private String companyName;
	private String companyPicthre;
	private int score;
	
	
	
	
	public MainCompanyDto(int companyNum, String companyName, String companyPicthre, int score) {
		super();
		this.companyNum = companyNum;
		this.companyName = companyName;
		this.companyPicthre = companyPicthre;
		this.score = score;
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
	public String getCompanyPicthre() {
		return companyPicthre;
	}
	public void setCompanyPicthre(String companyPicthre) {
		this.companyPicthre = companyPicthre;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "MainCompanyDto [companyNum=" + companyNum + ", companyName=" + companyName + ", companyPicthre="
				+ companyPicthre + ", score=" + score + "]";
	}
	
	
}