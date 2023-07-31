package com.kfh.coursers.Management.Rest.Service.api.repository;

import com.kfh.coursers.Management.Rest.Service.api.entity.Course;
import com.kfh.coursers.Management.Rest.Service.api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    List<Course> getAllCourseOfStudent(Student student);
}
