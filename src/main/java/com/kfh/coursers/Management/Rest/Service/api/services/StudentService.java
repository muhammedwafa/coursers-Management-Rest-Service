package com.kfh.coursers.Management.Rest.Service.api.services;


import com.kfh.coursers.Management.Rest.Service.api.payloads.CourseDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.RegistrationDetailsDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);
    StudentDto updateStudent(StudentDto studentDto, Integer student_id);

    List<CourseDto> getAllCourses();

    void joinCourse(RegistrationDetailsDto registrationDetailsDto);
    //	void leaveCourse(Integer id);

}
