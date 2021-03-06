package com.medical.solutions.constants;

public interface LoginQueryConstants {

	String IS_EXIST = "SELECT * FROM login ";
	
	String IS_DOCTOR_EXIST = "SELECT * FROM doctor_detail where doctor_number=? and password=?";
	
	String ADD_DOCTOR = "INSERT INTO login (mobile,Password,adhaar,email,type,createdDate,updatedDate) values (?,?,?,?,?,NOW(),NOW())";
	
	String INSERT_LOGIN = "insert into login (mobile,password,adhaar,email,type,typeId,createdDate) values (?,?,?,?,?,?, NOW())";
}
