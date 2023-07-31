package com.kfh.coursers.Management.Rest.Service.api.controllers;


import com.kfh.coursers.Management.Rest.Service.api.payloads.ApiResponse;
import com.kfh.coursers.Management.Rest.Service.api.payloads.CourseDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.RegistrationDetailsDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.StudentDto;
import com.kfh.coursers.Management.Rest.Service.api.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// register student
	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerStudent(@Valid @RequestBody StudentDto studentDto) {
		// call the service to save the student to the database.
		return new ResponseEntity<ApiResponse> (
				new ApiResponse("Student Registered Successfully!!", 200),HttpStatus.OK);
	}


	@GetMapping("/")
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		//get - getAllCourse
		//should have rest client to consume the method in course controller.
		return ResponseEntity.ok(this.studentService.getAllCourses());
	}


	// allocate student to specific course
	@PostMapping("/register/addStudentToCourse")
	public ResponseEntity<ApiResponse> joinCourse(@Valid @RequestBody RegistrationDetailsDto courseRegistrationDto){
		this.studentService.joinCourse(courseRegistrationDto);
		return new ResponseEntity<ApiResponse> (
				new ApiResponse("Leave Course Successfully!!", 200),HttpStatus.OK);
	}

	// update
	@PutMapping("/{student_id}")
	public ResponseEntity<StudentDto> updateStudentDetails(@Valid @RequestBody StudentDto studentDto,
														   @PathVariable Integer student_id){
		StudentDto updatedStudent = this.studentService.updateStudent(studentDto, student_id);
		return ResponseEntity.ok(updatedStudent);
	}

	//delete- leaveCourse
	@DeleteMapping("/{course_id}")
	public ResponseEntity<ApiResponse> leaveCourse(@PathVariable Integer course_id){
	//	this.studentService.leaveCourse(course_id);
		return new ResponseEntity<ApiResponse> (
				new ApiResponse("Leave Course Successfully!!", 200),HttpStatus.OK);
	}
	
}











