package com.example.CourseProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseProject.Model.Signup;


@Repository
public interface SignupRepo extends JpaRepository<Signup, Integer> {

//	UserProfile	findbyemail(String email);

	
	
}
