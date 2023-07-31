package com.kfh.coursers.Management.Rest.Service.api.repository;


import com.kfh.coursers.Management.Rest.Service.api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
