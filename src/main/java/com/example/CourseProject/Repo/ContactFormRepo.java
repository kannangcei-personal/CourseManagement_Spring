package com.example.CourseProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseProject.Model.Contact;


@Repository
public interface ContactFormRepo extends JpaRepository<Contact, Integer>{

	
	
}
