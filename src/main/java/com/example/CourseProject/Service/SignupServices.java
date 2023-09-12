package com.example.CourseProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CourseProject.Model.ApiResponse;
import com.example.CourseProject.Model.Signup;
import com.example.CourseProject.Repo.SignupRepo;

@Service
public class SignupServices {

	@Autowired
	private SignupRepo repo;
	
	// saving the User  DB and creating a new user record
	public ApiResponse save(@RequestBody Signup forms) {
		
		ApiResponse api = new ApiResponse();
		
		if(forms.getFirstName().isBlank() && forms.getEmail().isBlank() && forms.getPassword().isBlank()) {
			
			
			api.setValid("Failed");
			api.setStatus(false);
			
			
		}else {
		
			api.setStatus(true);
			repo.save(forms);
			
			
		}
		return api;
		
	}	


}
