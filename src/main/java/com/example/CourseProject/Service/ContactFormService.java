package com.example.CourseProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.CourseProject.Model.ApiResponse;
import com.example.CourseProject.Model.Contact;
import com.example.CourseProject.Repo.ContactFormRepo;

@Service
@CrossOrigin
public class ContactFormService {

	
	@Autowired
	private ContactFormRepo repo;
	
	
	public ApiResponse saveContact(Contact form) {
		
		ApiResponse api = new ApiResponse();
		
		if(form.getEmail().isBlank() &&  form.getMessage().isBlank()) {
			api.setValid("Contact Form");
			api.setStatus(false);
		}else {
			repo.save(form);
			api.setValid("Contact Form");
			api.setStatus(true);
		}
		return api;
	
	}
	
}
