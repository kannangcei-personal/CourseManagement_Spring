package com.example.CourseProject.Model;

public class ApiResponse {

	private String valid;
	
	private boolean status;

	public ApiResponse(String str, boolean b) {
		
		this.valid = str;
		this.status = b;
	}

	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
