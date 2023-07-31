package com.kfh.coursers.Management.Rest.Service.api.repository;

import com.kfh.coursers.Management.Rest.Service.api.entity.RegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationDetails, Long> {
    @Query(value = "SELECT * FROM db.courseRegistration WHERE courseId = ?1 and studentId = ?2", nativeQuery = true)
    public RegistrationDetails findRegisteredCourse(Integer courseId , Integer studentId);
}
