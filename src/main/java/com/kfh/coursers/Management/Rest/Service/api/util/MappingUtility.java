package com.kfh.coursers.Management.Rest.Service.api.util;

import com.kfh.coursers.Management.Rest.Service.api.entity.Course;
import com.kfh.coursers.Management.Rest.Service.api.entity.RegistrationDetails;
import com.kfh.coursers.Management.Rest.Service.api.entity.Student;
import com.kfh.coursers.Management.Rest.Service.api.payloads.CourseDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.RegistrationDetailsDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MappingUtility {
    @Autowired
    private ModelMapper modelMapper;
    //to change the CourseDto to the course;
    public Course dtoToCourse(CourseDto dto) {
        Course course = this.modelMapper.map(dto, Course.class);
        return course;
    }

    //to change the course to the courseDto;
    public CourseDto courseToDto(Course course) {
        CourseDto dto = this.modelMapper.map(course, CourseDto.class);
        return dto;
    }

    public Student dtoToStudent(StudentDto dto) {
        Student student = this.modelMapper.map(dto, Student.class);
        return student;
    }

    //to change the student to the studentDto;
    public StudentDto studentToDto(Student student) {
        StudentDto dto = this.modelMapper.map(student, StudentDto.class);
        return dto;
    }

    //to change the CourseDto to the course;
    public RegistrationDetails dtoToReg(CourseDto dto) {
        RegistrationDetails registrationDetails = this.modelMapper.map(dto, RegistrationDetails.class);
        return registrationDetails;
    }

    //to change the course to the courseDto;
    public RegistrationDetailsDto regToDto(RegistrationDetails registrationDetails) {
        RegistrationDetailsDto dto = this.modelMapper.map(registrationDetails, RegistrationDetailsDto.class);
        return dto;
    }

}
