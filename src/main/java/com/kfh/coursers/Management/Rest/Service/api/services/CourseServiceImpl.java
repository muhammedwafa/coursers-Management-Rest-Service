package com.kfh.coursers.Management.Rest.Service.api.services;

import com.kfh.coursers.Management.Rest.Service.api.entity.Course;
import com.kfh.coursers.Management.Rest.Service.api.exception.ResourseNotFoundException;
import com.kfh.coursers.Management.Rest.Service.api.payloads.CourseDto;
import com.kfh.coursers.Management.Rest.Service.api.payloads.StudentDto;
import com.kfh.coursers.Management.Rest.Service.api.repository.CourseRepo;
import com.kfh.coursers.Management.Rest.Service.api.util.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;
    @Autowired
    private MappingUtility mappingUtility;

    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        Course course = this.mappingUtility.dtoToCourse(courseDto);
        Course savedCourse= courseRepo.save(course);
        return this.mappingUtility.courseToDto(savedCourse); // converting the object back to dto
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto, Integer student_id) {
        return null;
    }


    @Override
    public CourseDto updateCourse(Integer courseId, CourseDto courseDto) {
        Course course =this.courseRepo.findById(courseId)
                .orElseThrow(()-> new ResourseNotFoundException("Course", "course_id", courseId));
        course.setCourseName(courseDto.getCourseName());
        course.setDescription(courseDto.getDescription());
        course.setDuration(courseDto.getDuration());
        course.setCourseType(courseDto.getCourseType());
        course.setStartDate(courseDto.getStartDate());
        Course updatedCourse = this.courseRepo.save(course);
        return this.mappingUtility.courseToDto(updatedCourse);

    }
    @Override
    public void deleteCourse(Integer courseId) {
        Course course = this.courseRepo.findById(courseId)
                .orElseThrow(()-> new ResourseNotFoundException("Course", "Course", courseId));
        this.courseRepo.delete(course);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = this.courseRepo.findAll();
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course course: courses) {
            CourseDto dto = this.mappingUtility.courseToDto(course); // converting course to dto .
            courseDtos.add(dto);
        }
        return courseDtos;
    }

    @Override
    public List<StudentDto> getAllStudents(Integer courseId) {
        Course course = this.courseRepo.findById(courseId)
                .orElseThrow(()-> new ResourseNotFoundException("Course", "Course", courseId));

        return null;
    }



}
