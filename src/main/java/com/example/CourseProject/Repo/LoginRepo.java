package com.example.CourseProject.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.CourseProject.Model.Signup;


@Repository
public interface LoginRepo extends JpaRepository<Signup,Integer> {

	@Query("SELECT u FROM Signup u WHERE u.email = :email AND u.password = :password")
	Signup findOneByemailIgnorepassword(String email, String password);

//	@Query("SELECT s FROM Signup s WHERE s.email = :userEmail")
//	Signup findbyemail(String useremail);

	
	@Query("SELECT s FROM Signup s WHERE s.email = :userEmail")
	Signup findbyemail(@Param("userEmail") String userEmail);


}
