package com.kfh.coursers.Management.Rest.Service.api.controllers;

import com.kfh.coursers.Management.Rest.Service.api.payloads.ApiResponse;
import com.kfh.coursers.Management.Rest.Service.api.payloads.CourseDto;
import com.kfh.coursers.Management.Rest.Service.api.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    // add course
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCourse( @Valid @RequestBody CourseDto courseDto) {
        //pass the request body to the service to be saved in db
        courseService.addCourse(courseDto);
        return new ResponseEntity<ApiResponse> (
                new ApiResponse(" Course Added Successfully!!", 200),HttpStatus.OK);
    }

    // update course
    @PutMapping("/update/{course_id}")
    public ResponseEntity<ApiResponse> updateCourse(@PathVariable Integer course_id,
                                                    @Valid @RequestBody CourseDto courseDto) {
        //pass the request body to the service to be saved in db
        courseService.updateCourse(course_id,courseDto);
        return new ResponseEntity<ApiResponse> (
                new ApiResponse(" Course Updated Successfully!!", 200),HttpStatus.OK);
    }

    // delete course
    @DeleteMapping("/delete/{course_id}")
    public ResponseEntity<ApiResponse> deleteCourse(@PathVariable Integer course_id) {
        //pass the request body to the service to be saved in db
        courseService.deleteCourse(course_id);
        return new ResponseEntity<ApiResponse> (
                new ApiResponse(" Course Updated Successfully!!", 200),HttpStatus.OK);
    }

    // get curses
    @GetMapping("/courses")
    public ResponseEntity<List<CourseDto>> getCourses() {
        List<CourseDto> courses = courseService.getAllCourses();
        return new ResponseEntity<> (courses,HttpStatus.OK);
    }

}

