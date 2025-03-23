package com.blueAnt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.blueAnt.SimpleAppServices.ISimpleApplicationService;
import com.blueAnt.SqlQueries.commonQueries;
import com.blueAnt.dao.RegistrationRowMapper;
import com.blueAnt.domain.RegistrationDTO;



@Controller
public class HomePageController {
	
	@Autowired
	ISimpleApplicationService simpleapplicationservice;
	
	@GetMapping("/blueant")
	public String applicationLogin() {
		
		return "pages/Login/login";
	}
	
	@GetMapping("/signup")
	public String applicationSignup() {
		
		return "pages/Login/signup";
	}
	
	@PostMapping("/login")
	public String UserLogin(@ModelAttribute("registrationDTO") RegistrationDTO regdto) {
		String view = "";
		String sql = new commonQueries().checkLogin;
		
		List<RegistrationDTO> validUser = simpleapplicationservice.fetchTemplate().query(sql,
									new RegistrationRowMapper(), new Object[] {regdto.getUserName(),regdto.getPassword()});
		
		if(!validUser.isEmpty()) {
			view= "pages/HomePage/homePage";
		}else {
			view= "pages/Login/login";
		}
		
		return view;
	}
	
	@PostMapping("/register")
	public String applicationRegister( @ModelAttribute("registrationDTO") RegistrationDTO regdto,Model model ) {
		String userIdQuery = new commonQueries().lastRegIdInUser;
		List<RegistrationDTO> lastUserId =  simpleapplicationservice.fetchTemplate().query(userIdQuery, new RegistrationRowMapper());
		int lastRegUser = 0 ;
		if(!lastUserId.isEmpty()) {
		 lastRegUser = (int) lastUserId.get(0).getUserId();
		 lastRegUser =lastRegUser+1;
		}else {
			lastRegUser = 1;
		}
		String sql =new commonQueries().saveRegistrationDetails;
		if(lastRegUser != 0) {
		simpleapplicationservice.fetchTemplate().update(sql,
				new Object[] {lastRegUser,regdto.getUserName(),regdto.getPassword(),regdto.getAge(),regdto.getEmail()});
		}
		String message = "Success";
		model.addAttribute("popupMessage", message);
		return "pages/Login/regSuccess";
	}

}
