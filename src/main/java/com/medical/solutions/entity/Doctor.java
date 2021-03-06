package com.medical.solutions.entity;

import java.util.Date;

public class Doctor extends DoctorAddress{

	private Integer dId;
	private String name;
	private String mobile;
	private String homeAddress;
	private String aadhaarNumber;
	private String highestDegree;
	private String expertized;
	private Boolean isGovernmentServent;
	private String oneTimeFee;
	private Integer daysCheckFree;
	private String clinicAddress;
	private String email;
	private String gender;
	private Date DOB;
	private String password;
	private String desc;
	private String profilePath;
	
	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getHighestDegree() {
		return highestDegree;
	}

	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	public String getExpertized() {
		return expertized;
	}

	public void setExpertized(String expertized) {
		this.expertized = expertized;
	}

	public Boolean getIsGovernmentServent() {
		return isGovernmentServent;
	}

	public void setIsGovernmentServent(Boolean isGovernmentServent) {
		this.isGovernmentServent = isGovernmentServent;
	}

	public String getOneTimeFee() {
		return oneTimeFee;
	}

	public void setOneTimeFee(String oneTimeFee) {
		this.oneTimeFee = oneTimeFee;
	}

	public Integer getDaysCheckFree() {
		return daysCheckFree;
	}

	public void setDaysCheckFree(Integer daysCheckFree) {
		this.daysCheckFree = daysCheckFree;
	}

	public String getClinicAddress() {
		return clinicAddress;
	}

	public void setClinicAddress(String clinicAddress) {
		this.clinicAddress = clinicAddress;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		this.DOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Doctor [dId=" + dId + ", name=" + name + ", mobile=" + mobile + ", homeAddress=" + homeAddress
				+ ", aadhaarNumber=" + aadhaarNumber + ", highestDegree=" + highestDegree + ", expertized=" + expertized
				+ ", isGovernmentServent=" + isGovernmentServent + ", oneTimeFee=" + oneTimeFee + ", daysCheckFree="
				+ daysCheckFree + ", clinicAddress=" + clinicAddress + "]";
	}

}
