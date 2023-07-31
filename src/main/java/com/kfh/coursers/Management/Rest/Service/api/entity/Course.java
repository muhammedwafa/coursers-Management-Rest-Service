package com.kfh.coursers.Management.Rest.Service.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	
	@Column(nullable = false,length=20)
	private String courseName;
	
	@Column(nullable = false,length=100)
	private String description;
	
	@Column(nullable = false,length=20)
	private String duration;
	
	@Column(nullable = false,length=20)
	private String courseType;

	@Column(nullable = false,length = 50)
	private String startDate;

	@OneToMany(mappedBy = "course")
	Set<RegistrationDetails> registrations;
}
