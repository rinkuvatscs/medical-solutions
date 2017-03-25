package com.medical.patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.patient.dao.PatientDao;
import com.medical.patient.entity.Appointment;
import com.medical.patient.entity.Patient;
import com.medical.patient.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	public Boolean checkMobile(String mobile) {
		return patientDao.checkMobile(mobile);
	}

	@Override
	public Boolean checkAdhaar(String adhaar) {
		return patientDao.checkAdhaar(adhaar);
	}

	@Override
	public Boolean checkEmail(String email) {
		return patientDao.checkEmail(email);
	}

	@Override
	public Integer patientSignUp(Patient patient) {
		return patientDao.patientSignUp(patient);
	}

	@Override
	public String addpatient(Patient patient) {
		return patientDao.addpatient(patient);
	}

	@Override
	public String deletepatient(Patient patient) {
		return patientDao.deletepatient(patient);
	}

	@Override
	public Patient getpatientByMobileNumber(String mobileNumber) {
		return patientDao.getpatientByMobileNumber(mobileNumber);
	}

	@Override
	public Patient getpatientByAdharNumber(String adharNumber) {
		return patientDao.getpatientByAdharNumber(adharNumber);
	}

	@Override
	public Patient getpatientByEmail(String email) {
		return patientDao.getpatientByEmail(email);
	}

	@Override
	public List<Patient> getpatientByName(String name) {
		return patientDao.getpatientByName(name);
	}

	@Override
	public Patient getpatientById(Integer id) {
		return patientDao.getpatientById(id);
	}

	@Override
	public String updatepatient(Patient patient) {
		return patientDao.updatepatient(patient);
	}
	
	@Override
	public String makeAppointment(Appointment makeAppointment) {

		return patientDao.makeAppointment(makeAppointment);
	}

	@Override
	public String cancelAppoinment(Integer id) {

		return patientDao.cancelAppointment(id);
	}

	@Override
	public List<Appointment> viewAppointment(Integer pId) {

		return patientDao.viewAppointment(pId);
	}

}
