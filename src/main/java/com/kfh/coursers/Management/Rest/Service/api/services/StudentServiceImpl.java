package com.kfh.coursers.Management.Rest.Service.api.services;

import com.kfh.coursers.Management.Rest.Service.api.entity.Course;
import com.kfh.coursers.Management.Rest.Service.api.entity.RegistrationDetails;
import com.kfh.coursers.Management.Rest.Service.api.entity.Student;
import com.kfh.coursers.Management.Rest.Service.api.exception.ResourceNotFoundException;
import com.kfh.coursers.Management.Rest.Service.api.payloads.CourseDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.RegistrationDetailsDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.StudentDto;
import com.kfh.coursers.Management.Rest.Service.api.repository.CourseRepo;
import com.kfh.coursers.Management.Rest.Service.api.repository.StudentRepo;
import com.kfh.coursers.Management.Rest.Service.api.util.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private MappingUtility mappingUtility;

    //to change the studentDto to the student;


    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = this.mappingUtility.dtoToStudent(studentDto);
        Student savedStudent1 = studentRepo.save(student);
        return this.mappingUtility.studentToDto(savedStudent1);
    }


    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> list = this.courseRepo.findAll();
        List<CourseDto> dto = list.
                stream().
                map(student -> this.mappingUtility.courseToDto(student))
                .collect(Collectors.toList());
        return dto;
    }

    @Override
    public void joinCourse(RegistrationDetailsDto registrationDetailsDto) {
        // allocate student to specific course

    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Integer student_id) {
        Student student = this.studentRepo.findById(student_id).
                orElseThrow(() -> new ResourceNotFoundException("Student", "Student_id", student_id));
        student.setEmail(studentDto.getEmail());
        student.setMobileNumber(studentDto.getMobileNumber());
        Student updatedStudent = this.studentRepo.save(student);
        return this.mappingUtility.studentToDto(updatedStudent);
    }


}
