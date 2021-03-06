/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medical.solutions.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.solutions.entity.Doctor;

/**
 *
 * @author Rinku
 */
public class DoctorExtractor implements ResultSetExtractor<List<Doctor>> {

	List<Doctor> doctorList = new ArrayList<>();

	@Override
	public List<Doctor> extractData(ResultSet rs) throws SQLException {
		Doctor doctor;

		while (rs.next()) {
			doctor = new Doctor();
			doctor.setAadhaarNumber(rs.getString("adhaar"));
			doctor.setDaysCheckFree(rs.getInt("freeDay"));
			doctor.setExpertized(rs.getString("expertise"));
			doctor.setIsGovernmentServent(rs.getBoolean("gov"));
			doctor.setHighestDegree(rs.getString("highestDegree"));
			doctor.setHomeAddress(rs.getString("homeAddress"));
			doctor.setdId(rs.getInt("dId"));
			doctor.setName(rs.getString("name"));
			doctor.setMobile(rs.getString("mobile"));
			doctor.setOneTimeFee(rs.getString("fee"));
			doctor.setClinicAddress(rs.getString("clinic"));
			doctor.setEmail(rs.getString("email"));
			doctor.setGender(rs.getString("gender"));
			doctor.setTiming(rs.getString("timing"));
			doctor.setState(rs.getString("state"));
			doctor.setDesc(rs.getString("desc"));
			doctor.setProfilePath(rs.getString("profilePicPath"));
			doctor.setDOB(rs.getDate("dob"));
			doctorList.add(doctor);
		}
		return doctorList;
	}

}