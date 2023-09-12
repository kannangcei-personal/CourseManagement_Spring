package com.example.CourseProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseProject.Model.ApiResponse;
import com.example.CourseProject.Model.Course;
import com.example.CourseProject.Service.CourseService;

@CrossOrigin
@RestController
@RequestMapping
public class CourseController {

	
	@Autowired
	private CourseService service;
	
	@GetMapping("/api/course")
	public List<Course> getAllCourse(){
		
		return service.getAllCourse();
	}
	
	
	
	@PostMapping("/api/course/create")
	public ResponseEntity<ApiResponse> createCourse(@RequestBody Course courseitem){
		
		//calling and passsing a controller to service
		ApiResponse api = service.addCourse(courseitem);
		
		//geting response from services 
		
		ApiResponse response = new ApiResponse(api.getValid(),api.isStatus());
		 
		// return the reponse
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);

	}
	
	@DeleteMapping("/api/course/delete/{id}")
	public void deletedCourse(@PathVariable Long id){
		
		service.deleteCourse(id);
//		
	}
	
	
	
	@GetMapping("/api/course/{id}")
	public Course getCoursebyid(@PathVariable Long id) throws Exception {
		
		return service.getByCourseId(id);
		
	}
	
	
	
	
	
}
