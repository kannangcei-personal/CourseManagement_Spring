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
import com.example.CourseProject.Model.Signup;
import com.example.CourseProject.Service.SignupServices;


@CrossOrigin
@RestController
@RequestMapping
public class SignupController {

	
	
	@Autowired
	private SignupServices servicessign;
	

	
	// Signup Create an new User Record 
	
	@PostMapping("/api/signup")
	public ResponseEntity<ApiResponse> StoreDetailes(@RequestBody Signup signupdata){

	// send form to service class
	ApiResponse api = servicessign.save(signupdata);
	System.out.println(signupdata);			
		
	// receive the response form service and display it
	ApiResponse response = new ApiResponse(api.getValid(),api.isStatus());
	 return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}
	
		
}


