package com.medical.solutions.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

public class ExpertizedExtractor implements
		ResultSetExtractor<List<String>> {

	@Override
	public List<String> extractData(ResultSet rs) throws SQLException {

		List<String> expertizeds = new ArrayList<>();
		while (rs.next()) {

			expertizeds.add(rs.getString("expertise"));
		}
		return expertizeds;

	}

}
