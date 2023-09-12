package com.example.CourseProject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CourseProject.Model.ApiResponse;
import com.example.CourseProject.Model.Course;
import com.example.CourseProject.Repo.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private CourseRepo repo;
	
	
	
	// Get all course
	
	public List<Course> getAllCourse(){
		
		List<Course> courseslist = new ArrayList<>();
		
		repo.findAll().forEach(courseslist::add);
		
		return courseslist;
	}
	
	
	// Add Course Service
	
	public ApiResponse addCourse(Course courseitem) {	
		
		ApiResponse api = new ApiResponse();
		
		Course save =repo.save(courseitem);
		if(save != null) {
			api.setValid("Course Created");
			api.setStatus(true);
			}
		else {
			api.setStatus(false);
			api.setValid("Course Not create");
			}
		return api;
	}
	

	public void deleteCourse(Long id) {
		
		 repo.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Course getByCourseId(Long courseid) throws Exception {
		
		 Optional<Course> course = repo.findById(courseid);
		    if(course.isPresent()) {
		      return course.get();
		      
		    }else
		    {
		      throw new Exception("Not found");
		    }
	}
	
	
}