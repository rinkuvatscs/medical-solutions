package com.doctor.db.config;

public interface QueryConstants {

	String ADD_DOCTOR = "insert into  doctor_detail(doctor_name,doctor_number,doctor_homeaddress,doctor_adhaar_number,doctor_highestdegree,doctor_expertized,is_doctor_govt_servant,onetime_consulting_fee,doctor_days_to_check_free_in_consulting_fee,doctor_shop_address)"
			+ " values" + "(?,?,?,?,?,?,?,?,?,?)";

	String IS_DOCTOR_EXIST = "SELECT * FROM doctor_detail WHERE doctor_number = ? OR doctor_adhaar_number = ?";

	String DELETE_DOCTOR = "delete from doctor_detail WHERE doctor_id = ?";

	String GET_DOCTOR_BY_ID = " SELECT * FROM doctor_detail WHERE doctor_id = ? ";
	
	String GET_DOCTOR_BY_ADHAR_NUMBER = " SELECT * FROM doctor_detail WHERE doctor_id = ? ";

	String GET_DOCTOR_BY_MOBILE_NUMBER = " SELECT * FROM doctor_detail WHERE doctor_id = ? ";
	
	String GET_DOCTOR_BY_NAME = " SELECT * FROM doctor_detail WHERE doctor_name LIKE ? ";
}
