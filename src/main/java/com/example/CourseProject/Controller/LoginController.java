package com.example.CourseProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.CourseProject.Model.Signup;
import com.example.CourseProject.Service.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import com.example.CourseProject.Model.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@CrossOrigin
	@PostMapping("/api/login")
	public ResponseEntity<ApiResponse> authenticate(@RequestBody Signup form,HttpServletResponse response){
		
		//calling the services
		ApiResponse api = service.login(form);
		
		 
		//store the response in 
		ApiResponse responseapi = new ApiResponse(api.getValid(),api.isStatus());
		return new ResponseEntity<ApiResponse>(responseapi, HttpStatus.OK);
		
	}
	
	@PostMapping("/api/emailcheck")
	public Boolean emailcheck(@RequestBody Signup form) {
		
		String email = form.getEmail();
		
		return service.EmailExistcheck(email);
		
	}
	
	@GetMapping("/api/testing")
	public String check() {
		return "Hello logged in";
	}
	
	@GetMapping("/gettingcookie")
	public String readCookie(@CookieValue(value = "email", defaultValue = "not assigned") String email) {
	    
		return "This cookie is assigned" + email;
	}
	

	@GetMapping("/setcookie")
	public void setcookieclass( Signup form, HttpServletResponse response) {
		
		Cookie emailCookie = new Cookie("email", "test@gmail.com");
		emailCookie.setPath("/");
		emailCookie.setMaxAge(20000);
		response.addCookie(emailCookie);
		System.out.println("cookie is created");
	}
	
	
	
	@GetMapping("/api/getuserinfo")
	public Signup getUserdetail() {
		return service.getUserinfo();
	}
	
	@CrossOrigin
	@PutMapping("/api/updateprofile")
	public void updateProfile(@RequestBody Signup form) {
		
		service.updateProfileData(form);
		
		System.out.println("Update successfully!");
		
	}
	
	
	
	
	
	
}
