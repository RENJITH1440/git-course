package com.blueAnt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.blueAnt.domain.productCategory;

public class productCategoryRowMapper implements RowMapper<productCategory> {

	@Override
	public productCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		productCategory category = new productCategory();
		category.setId(Long.valueOf(""+rs.getInt("Id")));
		category.setDescription(rs.getString("description"));
		return category;
	}

}
