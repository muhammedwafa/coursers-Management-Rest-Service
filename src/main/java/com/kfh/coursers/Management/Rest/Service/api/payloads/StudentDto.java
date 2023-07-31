package com.kfh.coursers.Management.Rest.Service.api.payloads;

import com.kfh.coursers.Management.Rest.Service.api.entity.Course;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private int student_id;

    @NotEmpty
    @Size(min = 4, message = "Name must be min of 4 character!!!")
    private String name;

    @NotEmpty
    @Pattern(regexp = "(0/91)?[6-9][0-9]{9}", message = "MobileNumber must be 10 Integers.")
    private String mobileNumber;

    @Email(message = "Please Enter Valid Email")
    private String email;

    private List<CourseDto> courseDtoList;


}
