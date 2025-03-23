package com.blueAnt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.blueAnt.domain.RegistrationDTO;

public class RegistrationRowMapper implements RowMapper<RegistrationDTO> {

	@Override
	public RegistrationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegistrationDTO registration = new RegistrationDTO();
		registration.setUserId(rs.getInt("userId"));
		registration.setUserName(rs.getString("UserName"));
		registration.setPassword(rs.getString("password"));
		registration.setAge(rs.getInt("age"));
		registration.setEmail(rs.getString("email"));
		return registration;
	}

}
