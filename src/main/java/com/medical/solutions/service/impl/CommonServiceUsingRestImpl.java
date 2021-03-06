package com.medical.solutions.service.impl;

import java.util.List;

import com.medical.solutions.entity.CalendarService;
import com.medical.solutions.entity.MessageService;
import com.medical.solutions.entity.NotificationService;
import com.medical.solutions.entity.TodoListService;
import com.medical.solutions.enums.CommonServiceEnum;
import com.medical.solutions.service.CommonService;

public class CommonServiceUsingRestImpl implements CommonService {

	@Override
	public CommonServiceEnum getCommonService() {

		return CommonServiceEnum.THROUGH_RESTTEMPLATE;
	}

	@Override
	public List<MessageService> getMessageForPatient(int pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateMessage(MessageService messageService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addMessageForPatient(MessageService messageService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MessageService> getMessageForDoctor(int dId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addMessageForDoctor(MessageService messageService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotificationService> getNotifyForPatient(int pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateNotify(NotificationService notificationService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNotifyForPatient(NotificationService notificationService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotificationService> getNotifyForDoctor(int dId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNotifyForDoctor(NotificationService notificationService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodoListService> getToDOListForPateint(int pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addToDoListForPatient(TodoListService todoListService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateToDoListForPatient(TodoListService todoListService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteToDoListForPatient(TodoListService todoListService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodoListService> getToDOListForDoctor(int dId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addToDoListForDoctor(TodoListService todoListService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateToDoListForDoctor(TodoListService todoListService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteToDoListForDoctor(TodoListService todoListService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCalendarEventForPatient(CalendarService calendarService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCalendarEvent(CalendarService calendarService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCalendarEvent(CalendarService calendarService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarService> getCalendarEventForPatient(int pId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCalendarEventForDoctor(CalendarService calendarService) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CalendarService> getCalendarEventForDoctor(int dId) {
		// TODO Auto-generated method stub
		return null;
	}

}
