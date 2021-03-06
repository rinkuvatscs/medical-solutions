package com.medical.solutions.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medical.solutions.entity.Login;
import com.medical.solutions.entity.PatientLogin;
import com.medical.solutions.exceptionhandler.BadRequestException;
import com.medical.solutions.factory.LoginFactory;
import com.medical.solutions.factory.PatientLoginFactory;
import com.medical.solutions.request.LoginRequest;
import com.medical.solutions.request.PatientLoginRequest;
import com.medical.solutions.response.LoginResponse;

@RestController
@RequestMapping("/api/login")
@Api(basePath = "/login", value = "loginmanagement", description = "Operations with Landlords", produces = "application/json")
public class LoginController {

	@Autowired
	private LoginFactory loginFactory;

	@Autowired
	private PatientLoginFactory patientLoginFactory;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/drlogin", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Signup for login", notes = "Signup for login")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public LoginResponse drLoginValidate(@RequestBody LoginRequest loginRequest) {

		Login login = new Login();
		try {
			BeanUtils.copyProperties(loginRequest, login);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Login Do not have enough information", beansException);
		}
		if (!StringUtils.isEmpty(login)
				&& !StringUtils.isEmpty(login.getUsername())
				&& !StringUtils.isEmpty(login.getPassword())) {
			return new LoginResponse(loginFactory.getLoginService()
					.validateLogin(login));
		} else {
			throw new BadRequestException(
					"Login Username and Password should not be blank");
		}

	}

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/patientlogin", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "LogIn for Patient", notes = "LogIn for Patient")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Fields are with validation errors"),
			@ApiResponse(code = 201, message = "") })
	public LoginResponse patientLoginValidate(
			@RequestBody PatientLoginRequest patientLoginRequest) {

		PatientLogin patientLogin = new PatientLogin();
		try {
			BeanUtils.copyProperties(patientLoginRequest, patientLogin);
		} catch (BeansException beansException) {
			throw new BadRequestException(
					"Login Do not have enough information", beansException);
		}
		if (!StringUtils.isEmpty(patientLogin)
				&& !StringUtils.isEmpty(patientLogin.getUsername())
				&& !StringUtils.isEmpty(patientLogin.getPassword())) {
			return new LoginResponse(patientLoginFactory
					.getPatientLoginService().validateLogin(patientLogin));
		} else {
			throw new BadRequestException(
					"Login Username and Password should not be blank");
		}

	}
}
