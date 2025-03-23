package com.blueAnt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.blueAnt.domain.NewVendorRegistrationDTO;

public class vendordetailsRowMapper implements RowMapper<NewVendorRegistrationDTO> {

	@Override
	public NewVendorRegistrationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NewVendorRegistrationDTO vendor = new NewVendorRegistrationDTO();
		vendor.setId(rs.getInt("Id"));
		vendor.setVendorName(rs.getString("vendorName"));
		vendor.setGstRegNo(rs.getString("gstRegNo"));
		vendor.setContactNo(rs.getString("contactNo"));
		vendor.setAddress(rs.getString("address"));
		vendor.setCountry(rs.getString("country"));
		vendor.setState(rs.getString("state"));
		vendor.setDistrict(rs.getString("district"));
		return vendor;
	}

}
