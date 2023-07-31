package com.kfh.coursers.Management.Rest.Service.api.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Getter
@Setter
@Service
@AllArgsConstructor
public class ApiResponse {
	private String message;
	private int code;
}
