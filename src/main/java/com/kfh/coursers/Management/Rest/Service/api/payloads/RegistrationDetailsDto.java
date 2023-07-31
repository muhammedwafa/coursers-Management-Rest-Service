package com.kfh.coursers.Management.Rest.Service.api.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationDetailsDto {
    private Long id;
    @NotEmpty
    private int courseId;
    @NotEmpty
    private int StudentId;
    @NotEmpty
    LocalDateTime registeredAt;

    int grade;
}
