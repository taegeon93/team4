package com.kh.company.model.vo;

public class Company {
	private int companyNum;
	private String companyName;
	private String companyAddress;
	private String companyCategory;
	private String companyPicture;
	
	public Company() {
		super();
	}

	public Company(int companyNum, String companyName, String companyAddress, String companyCategory,
			String companyPicture) {
		super();
		this.companyNum = companyNum;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyCategory = companyCategory;
		this.companyPicture = companyPicture;
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

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyCategory() {
		return companyCategory;
	}

	public void setCompanyCategory(String companyCategory) {
		this.companyCategory = companyCategory;
	}

	public String getCompanyPicture() {
		return companyPicture;
	}

	public void setCompanyPicture(String companyPicture) {
		this.companyPicture = companyPicture;
	}

	@Override
	public String toString() {
		return "Company [companyNum=" + companyNum + ", companyName=" + companyName + ", companyAddress="
				+ companyAddress + ", companyCategory=" + companyCategory + ", companyPicture=" + companyPicture + "]";
	}
	
	
}
