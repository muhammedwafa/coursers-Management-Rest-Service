package com.kfh.coursers.Management.Rest.Service.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;

	@Column(nullable = false,length=50)
	private String area;
	
	@Column(nullable = false,length=50)
	private String state;
	
	@Column(nullable = false,length=50)
	private String district;
	
	@Column(nullable = false,length=50)
	private String pincode;
	
	@Column(nullable = false,length=50)
	private String addressType;
	
	@ManyToOne
	@JoinColumn(name="Student_id")
	private Student student;
}
