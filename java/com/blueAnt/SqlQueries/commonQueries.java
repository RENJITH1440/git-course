package com.blueAnt.SqlQueries;

public class commonQueries {

	public String saveRegistrationDetails = " INSERT INTO users (userId,UserName,PASSWORD,age,email) VALUES (?,?,?,?,?)";
	public String lastRegIdInUser = "SELECT u.* FROM users u ORDER BY u.userId DESC  LIMIT 1 ";
	public String  checkLogin = " SELECT u.* FROM users u WHERE u.UserName =? AND PASSWORD = ? ";
	public String fetchCategories = " SELECT p.Id ,p.`description` FROM `productcategory` p ";
	public String fetchSubCategory =" SELECT p.Id,p.subCategoryDesc,p.category_id FROM  productsubcategory p ";
	public String saveVendorDetail = " INSERT INTO vendors (Id,`vendorName`,`GstRegNo`,`contactNo`,`Address`,`Country`,`State`,`district`) VALUES (?,?,?,?,?,?,?,?) ";
	public String lastRegVendor = "SELECT u.* FROM vendors u ORDER BY u.Id DESC  LIMIT 1 ";
	public String fetchAllVendors = "SELECT u.* FROM vendors u ORDER BY u.Id DESC ";
	public String lastaddedProductId =" SELECT p.* FROM products p ORDER BY p.id DESC LIMIT 1 ";
	public String saveproduct = " INSERT INTO `products` (`id`,`productName`,`price`,`discount`,`category`,`subcategory`,`sellerId`) VALUES (?,?,?,?,?,?,?) ";
}
