package com.example.CourseProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseProject.Model.ApiResponse;
import com.example.CourseProject.Model.Contact;
import com.example.CourseProject.Model.PasswordDTO;
import com.example.CourseProject.Service.ContactFormService;
import com.example.CourseProject.Service.LoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class ProfileController {
	
	@Autowired
	private LoginService loginservice;
	
	@Autowired
	private ContactFormService contactservice;
	
	
	
	public void getProfileinfo() {
		
		System.out.println("hello");
		
	}
	
	
	
	// Change user password
	
	@CrossOrigin
	@PostMapping("/api/changepassword")
	public ResponseEntity<ApiResponse> changepassword(@RequestBody PasswordDTO form) {
		
		ApiResponse	api = loginservice.changepassword(form);
		
		ApiResponse responseapi = new ApiResponse(api.getValid(),api.isStatus());
		return new ResponseEntity<ApiResponse>(responseapi, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/api/contact")
	public  ResponseEntity<ApiResponse> contactSaveResponse(@RequestBody Contact form) {
		
		ApiResponse api = contactservice.saveContact(form);
		
		ApiResponse responseapi = new ApiResponse(api.getValid(),api.isStatus());
		
		return new ResponseEntity<ApiResponse>(responseapi, HttpStatus.OK);
		
	}
	
	
	
	
	

}
