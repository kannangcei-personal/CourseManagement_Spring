package com.example.CourseProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.CourseProject.Model.ApiResponse;
import com.example.CourseProject.Model.PasswordDTO;
import com.example.CourseProject.Model.Signup;
import com.example.CourseProject.Repo.LoginRepo;

@Service
@CrossOrigin
public class LoginService {
	
	@Autowired
	private LoginRepo repo;
	
	public static String useremail;
	
	
	// Login authentication
	
	public ApiResponse login(Signup form) {
		
		ApiResponse api = new ApiResponse();
		
		Signup user =  repo.findOneByemailIgnorepassword(form.getEmail(),form.getPassword());

		 useremail = form.getEmail();
		
		if(user == null || user.getEmail().isBlank() == true) {
			
			api.setStatus(false);
			api.setValid("login");
		}else {
			
			api.setStatus(true);
			api.setValid("login");
		}
		return api;
	}
	
	
	// Email Exist Check before Signup Process
	
	public Boolean EmailExistcheck(String email ) {
		
		
		Signup user = repo.findbyemail(email);
		
		if(user != null ) {
			System.out.println("true");
			return true;
			
		}else {
			System.out.println("false");
			return false;
		}		
	}
	
	
	
	
	public Signup getUserinfo() {
		return repo.findbyemail(useremail);
		
	}
	
	
	
	// user profile Update
	public void updateProfileData(Signup form) {
	
	Signup user = repo.findbyemail(useremail);
		
	
	 if(form.getFirstName() != "") {
		 user.setFirstName(form.getFirstName());
		 System.out.println("fristname changed");
	 }
	 if(form.getLastName() != "") {
		 user.setLastName(form.getLastName());
		 System.out.println("lastname changed");
	 }
	 if(form.getAddress() != "") {
		 user.setAddress(form.getAddress());
		 System.out.println("add changed");
	 }
	 if(form.getHobbies() != "") {
		 user.setHobbies(form.getHobbies());
		 System.out.println("hobbie changed");
	 }
	 if(form.getJob() != "") {
		 user.setJob(form.getJob());
		 System.out.println("job changed");
	 }
	 if(form.getSkill() != "") {
		 user.setSkill(form.getSkill());
		 System.out.println("skill changed");
	 }
	 
	//save to DB
	 repo.save(user);
	 
	}
	
	//change password
	public ApiResponse changepassword(PasswordDTO form) {
		
		ApiResponse api = new ApiResponse();
		
		Signup user = repo.findbyemail(useremail);
		
		//validate current password is entered is correct
		if(form.getCurrentpassword().equals(user.getPassword())) {
			
			user.setPassword(form.getNewpassword());
			repo.save(user);
			api.setValid("Password Changed");
			api.setStatus(true);
			
		}else {
			
			api.setValid("Password Changed");
			api.setStatus(false);
		}
		
		return api;
	}
	
}
