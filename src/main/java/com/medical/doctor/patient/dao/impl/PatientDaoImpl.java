package com.medical.doctor.patient.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.medical.doctor.constants.QueryConstants;
import com.medical.doctor.entity.Doctor;
import com.medical.doctor.exceptionhandler.BadRequestException;
import com.medical.doctor.extractor.DoctorExtractor;
import com.medical.doctor.patient.constants.PatientLoginQueryConstants;
import com.medical.doctor.patient.constants.PatientQueryConstants;
import com.medical.doctor.patient.dao.PatientDao;
import com.medical.doctor.patient.entity.Patient;
import com.medical.doctor.patient.extractor.PatientExtractor;

import org.springframework.util.StringUtils;

@Component
public class PatientDaoImpl implements PatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer patientSignUp(Patient patient) {

		List<Patient> patientList = null;
		List<Object> args = new ArrayList<Object>();
		args.add(patient.getName());
		args.add(patient.getMobile());
		args.add(patient.getAdhaar());
		args.add(patient.getEmail());
		int patientResponse = jdbcTemplate.update(PatientQueryConstants.INSERT_PATIENT, args.toArray());
		if (patientResponse > 0) {
			args = new ArrayList<Object>();
			args.add(patient.getMobile());
			patientList = jdbcTemplate.query(PatientQueryConstants.GET_PATIENT_BY_MOBILE, new PatientExtractor(),
					args.toArray());
			if (!StringUtils.isEmpty(patientList) && !patientList.isEmpty()) {
				args = new ArrayList<>();
				args.add(patient.getMobile());
				args.add(patient.getPassword());
				args.add(patient.getAdhaar());
				args.add(patient.getEmail());
				args.add("p");
				args.add(patientList.get(0).getpId());
				int response = jdbcTemplate.update(PatientLoginQueryConstants.INSERT_LOGIN, args.toArray());
				if (response > 0) {
					return patientList.get(0).getpId();
				}
			}
		}
		return 0;
	}

	@Override
	public Boolean checkMobile(String mobile) {
		Object[] args = { mobile };
		List<Patient> response = jdbcTemplate.query("select * from patient where mobile = ? ", new PatientExtractor(),
				args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkAdhaar(String adhaar) {
		Object[] args = { adhaar };
		List<Patient> response = jdbcTemplate.query("select * from patient where adhaar = ? ", new PatientExtractor(),
				args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean checkEmail(String email) {
		Object[] args = { email };
		List<Patient> response = jdbcTemplate.query(" SELECT * from patient WHERE email = ? ", new PatientExtractor(),
				args);
		if (!response.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public String addpatient(Patient patient) {
		String response = null;
		if (!isPatientExists(patient)) {
			List<Object> args = new ArrayList<Object>();
			args.add(patient.getName());
			args.add(patient.getMobile());
			args.add(patient.getAdhaar());
			args.add(patient.getEmail());
			int row = jdbcTemplate.update(PatientQueryConstants.ADD_PATIENT, args.toArray());
			if (row == 1) {
				response = patient.getName() + " registered successfully";
			} else {
				response = "Sorry, " + patient.getName() + " not registered . Please try again";
			}
		} else {
			response = "Sorry, " + patient.getName() + " already registered";
		}
		return response;
	}

	private boolean isPatientExists(Patient patient) {

		boolean isExist = false;
		boolean isMobile = false, isAadhaar = false, isEmail = false, isDoctorId = false;

		StringBuffer query = new StringBuffer(PatientQueryConstants.IS_PATIENT_EXIST);
		List<String> args = new ArrayList<>();

		if (!StringUtils.isEmpty(patient.getAdhaar())) {
			query.append(" where adhaar = ?");
			args.add(patient.getAdhaar());
			isAadhaar = true;
		}

		if (!StringUtils.isEmpty(patient.getEmail())) {

			if (isAadhaar) {
				query.append(" or email = ?");
			} else {
				query.append(" where email = ?");
			}
			isEmail = true;
			args.add(patient.getEmail());
		}

		if (!StringUtils.isEmpty(patient.getMobile())) {

			if (isAadhaar || isEmail) {
				query.append(" or mobile = ?");
			} else {
				query.append(" where mobile = ?");
			}
			args.add(patient.getMobile());
		}

		List<Patient> response = jdbcTemplate.query(query.toString(), new PatientExtractor(), args.toArray());
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			isExist = true;
		}
		return isExist;

	}

	@Override
	public String deletepatient(Patient patient) {

		String response;
		String resp = "Please try again later";
		int delete;
		if (!StringUtils.isEmpty(patient)) {
			if (!StringUtils.isEmpty(patient.getpId()) && getpatientById(patient.getpId()) != null) {
				Object args[] = { patient.getpId() };
				delete = jdbcTemplate.update("DELETE FROM patient WHERE id = ? ", args);
				if (delete > 0) {
					response = "Patient with Patient ID " + patient.getpId() + " successfully Deleted";
				} else {
					response = resp;
				}
			} else if (!StringUtils.isEmpty(patient.getAadhaarNumber())
					&& getpatientByAdharNumber(patient.getAadhaarNumber()) != null) {
				Object args[] = { patient.getAadhaarNumber() };
				delete = jdbcTemplate.update("DELETE FROM patient WHERE patient_adhaar_number = ? ", args);
				if (delete > 0) {
					response = "Patient with Aadhar Number " + patient.getAadhaarNumber() + " successfully Deleted";
				} else {
					response = resp;
				}
			} else if (!StringUtils.isEmpty(patient.getMobile())
					&& getpatientByMobileNumber(patient.getMobile()) != null) {
				Object args[] = { patient.getMobile() };
				delete = jdbcTemplate.update("DELETE FROM patient WHERE patient_mobile_number = ? ", args);
				if (delete > 0) {
					response = "Patient with Mobile Number " + patient.getMobile() + " successfully Deleted";
				} else {
					response = resp;
				}
			} else {
				throw new BadRequestException(
						"Please provide valid Patient Id or Patient Adhar Number or Patient Mobile Number.");
			}
		} else {
			throw new BadRequestException("Patient can not be deleted without details {" + patient + "}");

		}
		return response;
	}

	@Override
	public Patient getpatientByMobileNumber(String mobileNumber) {

		if (!StringUtils.isEmpty(mobileNumber)) {
			Object args[] = { mobileNumber };
			List<Patient> response = jdbcTemplate.query(PatientQueryConstants.GET_PATIENT_BY_MOBILE,
					new PatientExtractor(), args);
			if (!StringUtils.isEmpty(response) && response.size() > 0) {
				return response.get(0);
			}
		}
		return new Patient();
	}

	@Override
	public Patient getpatientByAdharNumber(String adharNumber) {

		if (!StringUtils.isEmpty(adharNumber)) {
			Object args[] = { adharNumber };
			List<Patient> response = jdbcTemplate.query(PatientQueryConstants.GET_PATIENT_BY_ADHAR_NUMBER,
					new PatientExtractor(), args);
			if (!StringUtils.isEmpty(response) && response.size() > 0) {
				return response.get(0);
			}
		}
		return new Patient();
	}

	@Override
	public Patient getpatientByEmail(String email) {

		if (!StringUtils.isEmpty(email)) {
			Object args[] = { email };
			List<Patient> response = jdbcTemplate.query(PatientQueryConstants.GET_PATIENT_BY_EMAIL, args,
					new PatientExtractor());
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
				return response.get(0);
			}
		}
		return new Patient();
	}

	@Override
	public List<Patient> getpatientByName(String name) {

		if (!StringUtils.isEmpty(name)) {
			Object args[] = { "%" + name + "%" };
			List<Patient> response = jdbcTemplate.query(PatientQueryConstants.GET_PATIENT_BY_NAME,
					new PatientExtractor(), args);
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
				return response;
			}
		}
		return new ArrayList<Patient>();
	}

	@Override
	public Patient getpatientById(Integer id) {

		if (!StringUtils.isEmpty(id)) {
			Object args[] = { id };
			List<Patient> response = jdbcTemplate.query(PatientQueryConstants.GET_PATIENT_BY_ID, args,
					new PatientExtractor());
			if (!StringUtils.isEmpty(response) && !response.isEmpty()) {
				return response.get(0);
			}
		}
		return new Patient();
	}

	@Override
	public String updatepatient(Patient patient) {

		String response;
		List<Object> args = new ArrayList<>();
		StringBuilder query = new StringBuilder("UPDATE doctor_detail SET ");
		if (!StringUtils.isEmpty(patient)) {

			if (!StringUtils.isEmpty(patient.getEmail()) && !StringUtils.isEmpty(getpatientByEmail(patient.getEmail()))) {
				throw new BadRequestException("Updated Email ID already registered");
			}

			if (!StringUtils.isEmpty(patient.getAadhaarNumber())
					&& !StringUtils.isEmpty(getpatientByAdharNumber(patient.getAadhaarNumber()))) {
				throw new BadRequestException("Updated Aadhaar already registered");
			}

			if (!StringUtils.isEmpty(patient.getMobile())
					&& !StringUtils.isEmpty(getpatientByMobileNumber(patient.getMobile()))) {
				throw new BadRequestException("Updated Mobile Number already registered ");
			}

			boolean isPatientName = false;
			boolean isHomeAddress = false;
			boolean isMobile = false;
			boolean isAadhaar = false;
			boolean isAge = false;
			boolean isEmail = false;
			if (null != patient.getName()) {
				query.append(" Name = ? ");
				args.add(patient.getName());
				isPatientName = true;
			}
			/*if (null != patient.getHomeAddress()) {
				if (isPatientName) {
					query.append(" , HomeAddress = ? ");
					args.add(patient.getHomeAddress());
				} else {
					query.append(" HomeAddress = ? ");
					args.add(patient.getHomeAddress());
				}
				isHomeAddress = true;
			}*/
			
			if (null != patient.getMobile()) {
				if (isHomeAddress || isPatientName) {
					query.append(", mobile = ? ");

				} else {
					query.append(" mobile = ? ");
				}
				args.add(patient.getMobile());
				isMobile = true;
			}

			if (null != patient.getAadhaarNumber()) {
				if (isHomeAddress || isPatientName || isMobile) {
					query.append(", adhaar = ? ");

				} else {
					query.append(" adhaar = ? ");
				}
				args.add(patient.getAadhaarNumber());
				isAadhaar = true;
			}

			if (null != patient.getEmail()) {
				if (isHomeAddress || isPatientName || isMobile || isAadhaar || isAge) {
					query.append(", email = ? ");

				} else {
					query.append(" email = ? ");
				}
				args.add(patient.getEmail());
				isEmail = true;
			}

			if (null != patient.getGender()) {
				if (isHomeAddress || isPatientName || isMobile || isAadhaar || isAge || isEmail) {
					query.append(", gender = ? ");

				} else {
					query.append(" gender = ? ");
				}
				args.add(patient.getGender());
			}

			query.append(" WHERE pId = ? ");
			args.add(patient.getpId());

			int update = jdbcTemplate.update(query.toString(), args.toArray());
			if (update > 0) {
				// TODO need to Address details into addres table
				// TODO need to Login details into Login Table
				// TODO Login table details calling functions i am adding with
				// dummy impletations using factory pattern
				// that will be decided by LoginFactory class which class needs
				// to call .

			/*	loginFactory.getLoginService().addLoginDetails(patient);*/

				response = "patient successfully Updated...!!!";
			} else {
				response = "There is some problem, please try again later...!!!";
			}
		} else {
			response = "patient details are Empty, provide some details to update....!!!";
		}

		return response;
	}

}
