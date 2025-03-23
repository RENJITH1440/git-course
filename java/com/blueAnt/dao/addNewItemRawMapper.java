package com.blueAnt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.blueAnt.domain.NewProductDetailsDTO;


public class addNewItemRawMapper implements RowMapper<NewProductDetailsDTO> {

	@Override
	public NewProductDetailsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NewProductDetailsDTO dto = new NewProductDetailsDTO();
		dto.setId(rs.getInt("id"));
		dto.setProductName(rs.getString("productName"));
		dto.setPrice(rs.getString("price"));
		dto.setDiscount(rs.getString("discount"));
		dto.setCategory(rs.getLong("category"));
		dto.setCategory(rs.getLong("subcategory"));
		dto.setSellerId(rs.getLong("sellerId"));
		return dto;
	}

}
