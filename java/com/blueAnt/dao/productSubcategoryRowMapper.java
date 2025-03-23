package com.blueAnt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.blueAnt.domain.productSubCategory;

public class productSubcategoryRowMapper implements RowMapper<productSubCategory>{

	
	@Override
	public productSubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		productSubCategory subcategory = new productSubCategory();
		subcategory.setId(Long.valueOf(""+rs.getInt("id")));
		subcategory.setSubCategoryDesc(rs.getNString("subCategoryDesc"));
		subcategory.setCategory_id(Long.valueOf(""+rs.getInt("category_id")));
		return subcategory;
	}
}
