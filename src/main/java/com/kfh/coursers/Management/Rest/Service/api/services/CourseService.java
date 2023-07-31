package com.kfh.coursers.Management.Rest.Service.api.services;


import com.kfh.coursers.Management.Rest.Service.api.payloads.CourseDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.StudentDto;

import java.util.List;

public interface CourseService {
	CourseDto addCourse(CourseDto courseDto);
	CourseDto updateCourse(Integer courseId, CourseDto courseDto);
	void deleteCourse(Integer courseId);
	List<CourseDto> getAllCourses();
	List<StudentDto> getAllStudents(Integer courseId);
	StudentDto updateStudent(StudentDto studentDto , Integer student_id);


	
}
