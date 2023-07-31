package com.kfh.coursers.Management.Rest.Service.api.services;

import com.kfh.coursers.Management.Rest.Service.api.entity.RegistrationDetails;
import com.kfh.coursers.Management.Rest.Service.api.exception.ResourceNotFoundException;
import com.kfh.coursers.Management.Rest.Service.api.payloads.RegistrationDetailsDto;
import com.kfh.coursers.Management.Rest.Service.api.repository.RegistrationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {

    @Autowired
    RegistrationRepo courseRegistrationRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RegistrationDetailsDto registerStudentInCourse(RegistrationDetailsDto registrationDetailsDto) {
        RegistrationDetails registration = dtoToRegistration(registrationDetailsDto);
        RegistrationDetails saved = this.courseRegistrationRepo.save(registration);
        return registrationToDto(saved);
    }

    @Override
    public void leaveCourse(Integer courseId, Integer studentId) {
        RegistrationDetails registration = this.courseRegistrationRepo.findRegisteredCourse(courseId,studentId);
        if (registration.getStudent().getStudent_id() == studentId) {
            // delete teh entry
        } else {
            // throw the exception
            throw new ResourceNotFoundException("Student","studentId",studentId);
        }

    }

    //to change the CourseDto to the course;
    public RegistrationDetails dtoToRegistration(RegistrationDetailsDto dto) {
        RegistrationDetails course = this.modelMapper.map(dto, RegistrationDetails.class);
        return course;
    }

    //to change the course to the courseDto;
    public RegistrationDetailsDto registrationToDto(RegistrationDetails course) {
        RegistrationDetailsDto dto = this.modelMapper.map(course, RegistrationDetailsDto.class);
        return dto;
    }

}
