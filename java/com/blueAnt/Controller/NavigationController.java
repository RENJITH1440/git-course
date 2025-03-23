package com.blueAnt.Controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blueAnt.SimpleAppServices.ISimpleApplicationService;
import com.blueAnt.SimpleAppServices.impl.commonSession;
import com.blueAnt.SqlQueries.commonQueries;
import com.blueAnt.dao.addNewItemRawMapper;
import com.blueAnt.dao.productCategoryRowMapper;
import com.blueAnt.dao.productSubcategoryRowMapper;
import com.blueAnt.dao.vendordetailsRowMapper;
import com.blueAnt.domain.NewProductDetailsDTO;
import com.blueAnt.domain.NewVendorRegistrationDTO;
import com.blueAnt.domain.Vendors;
import com.blueAnt.domain.productCategory;
import com.blueAnt.domain.productSubCategory;



@Controller
public class NavigationController {
  
	@Autowired
	ISimpleApplicationService simpleapplicationservice;
	
	
	
	@GetMapping("/addNewitem")
	public String navigateToAdminPanel(Model model) {
		String sql = new commonQueries().fetchCategories;
		List <productCategory> category = simpleapplicationservice.fetchTemplate().query(sql, new productCategoryRowMapper()); 
		 sql = new commonQueries().fetchSubCategory;
		List <productSubCategory> subcategory = simpleapplicationservice.fetchTemplate().query(sql, new productSubcategoryRowMapper());
		sql=new commonQueries().fetchAllVendors;
		 List<NewVendorRegistrationDTO> vendors =  simpleapplicationservice.fetchTemplate().query(sql, new vendordetailsRowMapper() );
		
		model.addAttribute("category", category);
		model.addAttribute("subcategory", subcategory);
		model.addAttribute("vendors",vendors);
		return "pages/common/addNewitem";
	}
	
	@GetMapping("/categoryRegistration")
	public String navigateTocategory( Model model) {
		Session session =  new commonSession().session(productCategory.class);
		Query query = session.createQuery(" from productCategory");
		List<productCategory>  list = query.list();
		model.addAttribute("maincat", list);
		return "pages/common/categoryRegistration";
	}
	
	@PostMapping("/saveVendor")
	public String saveVendorDetails(@ModelAttribute("newVendorDEtail") Vendors vendor, Model model) {
	    try {
	        String sql = new commonQueries().lastRegVendor;
	        List<NewVendorRegistrationDTO> lastVendor = simpleapplicationservice.fetchTemplate().query(sql, new vendordetailsRowMapper());
	        int index = !lastVendor.isEmpty() ? (int) lastVendor.get(0).getId() + 1 : 1;

	        Vendors ven = new Vendors();
	        ven.setAddress(vendor.getAddress());
	        ven.setContactNo(vendor.getContactNo());
	        ven.setCountry(vendor.getCountry());
	        ven.setDistrict(vendor.getDistrict());
	        ven.setGstRegNo(vendor.getGstRegNo());
	        ven.setState(vendor.getState());
	        ven.setVendorName(vendor.getVendorName());

	        try (Session session = simpleapplicationservice.session()) {
	            Transaction transaction = session.beginTransaction();
	            session.save(ven);
	            transaction.commit();
	        } catch (Exception e) {
	            System.out.println("Error saving vendor: " + e.getMessage());
	        }

	        sql = new commonQueries().fetchAllVendors;
	        List<NewVendorRegistrationDTO> vendors = simpleapplicationservice.fetchTemplate().query(sql, new vendordetailsRowMapper());
	        model.addAttribute("vendors", vendors);
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	    return "pages/common/VendorRegistration";
	}
	
	@Value("${upload.dir}") 
    private String uploadDir;
	
	@PostMapping("/savenewitem")
	public String addnewitem (@ModelAttribute("addlineitem") NewProductDetailsDTO dto,@RequestParam("file") MultipartFile file,Model model) {
//		String sql = new commonQueries().lastaddedProductId;
//		List<NewProductDetailsDTO> lastaddedItem =  simpleapplicationservice.fetchTemplate().query(sql, new addNewItemRawMapper());
//		int index = 0;
//		if(!lastaddedItem.isEmpty()) {
//			index =(int) lastaddedItem.get(0).getId()+1;
//		}else {
//			index =1;
//		}
//		sql =new commonQueries().saveproduct;
//		simpleapplicationservice.fetchTemplate().update(sql, new Object[] {index,dto.getProductName(),dto.getPrice(),
//				dto.getDiscount(),dto.getCategory(),dto.getSubcategory(),dto.getSellerId()});
		String Uploadpath = null ;
		try {
            String filename[] =file.getOriginalFilename().split(".png");
            String originalFileName =filename[0]+System.currentTimeMillis()+ ".png";
            String destinationFilePath = uploadDir + File.separator + originalFileName;
            Uploadpath =destinationFilePath;
            File destinationFile = new File(destinationFilePath);
            file.transferTo(destinationFile);
            System.out.println("Upload complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		try (Session session = new commonSession().session(NewProductDetailsDTO.class)) {
            Transaction transaction = session.beginTransaction();
            dto.setUploadImagePath(Uploadpath);
            session.save(dto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error saving : " + e.getMessage());
        }
		
		return navigateToAdminPanel(model);
	}
	
	
	@PostMapping ("/savenewCategory")
	public String saveMainCategory(@ModelAttribute productCategory dto) {
		
		try (Session session = new commonSession().session(productCategory.class)) {
            Transaction transaction = session.beginTransaction();
            session.save(dto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error saving : " + e.getMessage());
        }
		
		return "pages/common/categoryRegistration";
	}
	
	@PostMapping ("/savenewSubCategory")
	public String saveSubCategory(@ModelAttribute productSubCategory dto) {
		if(dto.getId() == null && !dto.getSubCategoryDesc().isEmpty()) {
			try (Session session = new commonSession().session(productSubCategory.class)) {
	            Transaction transaction = session.beginTransaction();
	            session.save(dto);
	            transaction.commit();
	        } catch (Exception e) {
	            System.out.println("Error saving : " + e.getMessage());
	        }
		}
		
		return "pages/common/categoryRegistration";
	}
	
	@GetMapping("/vendorReg")
	public String navigateVendorReg(Model model) {
		
		String sql=new commonQueries().fetchAllVendors;
		 List<NewVendorRegistrationDTO> vendors =  simpleapplicationservice.fetchTemplate().query(sql, new vendordetailsRowMapper() );
		 model.addAttribute("vendors", vendors);
		 
		return "pages/common/VendorRegistration";
	}
	
	
	@GetMapping("/adminBay")
	public String navigateToadminBay() {
		return "pages/common/adminBay";
	}
	
	
	@GetMapping("/home")
	public String navigateTohome(Model model) {
		
		File uploadFolder = new File(uploadDir);

        File[] files = uploadFolder.listFiles();
        List<String> imageUrls = new ArrayList();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    imageUrls.add("file:///" + file.getAbsolutePath()); 
                }
            }
        }

        model.addAttribute("imageUrls", imageUrls);
		return "pages/HomePage/homePage";
	}
	


}
