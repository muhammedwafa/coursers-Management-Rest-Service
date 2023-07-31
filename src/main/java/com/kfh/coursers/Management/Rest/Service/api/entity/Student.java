package com.kfh.coursers.Management.Rest.Service.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int student_id;
	
	@Column(name="Full_Name" , nullable = false, length = 100)
	private String fullName;

	@Column(name = "Student_Email", nullable = false , length=100)
	private String email;

	@Column(name = "Student_Mobile_Number" , nullable = false, length=10)
	private String mobileNumber;
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();

	@OneToMany(mappedBy = "student")
	Set<RegistrationDetails> registrations;

}
