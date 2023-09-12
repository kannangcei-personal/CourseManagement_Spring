package com.example.CourseProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseProject.Model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

	
	
}
