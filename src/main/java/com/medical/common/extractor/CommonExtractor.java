package com.medical.common.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.medical.doctor.entity.MessageService;

public class CommonExtractor implements ResultSetExtractor<List<MessageService>> {

	@Override
	public List<MessageService> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<MessageService> messages = new ArrayList<MessageService>();
		MessageService message;

		while (rs.next()) {
			message = new MessageService();
			message.setMessageId(rs.getInt("messageId"));
			message.setMessage(rs.getString("message"));
			message.setdId(rs.getInt("dId"));
			message.setpId(rs.getInt("pId"));
			message.setStatus(rs.getBoolean("status"));
			messages.add(message);
		}
		return messages;
	}

}