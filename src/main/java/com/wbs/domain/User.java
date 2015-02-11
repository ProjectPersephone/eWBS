package com.wbs.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Users")
public class User {

	@Id
	private String emailId;

	private String employeeId;

	private String password;

	private String name;

	private List<String> project;

	private String role;

}
