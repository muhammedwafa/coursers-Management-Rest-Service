package com.kfh.coursers.Management.Rest.Service.api.services;

import com.kfh.coursers.Management.Rest.Service.api.payloads.RegistrationDetailsDto;

public interface CourseRegistrationService {
    public RegistrationDetailsDto registerStudentInCourse(RegistrationDetailsDto registrationDetailsDto);

    void leaveCourse(Integer courseId, Integer studentId);
}
