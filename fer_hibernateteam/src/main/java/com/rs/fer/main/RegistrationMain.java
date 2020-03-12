package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();

		User user = new User();
		user.setFirstname("anil");
		user.setMiddlename("kumar");
		user.setLastname("atthaluri");

		user.setUsername("anil");
		user.setPassword("1234");

		user.setEmailId("anil@gmail.com");
		user.setMobileno("1234567890");

		boolean isRegister = ferservice.registration(user);

		if (isRegister) {
			System.out.println("Registration completed successfully");
		} else {
			System.out.println("Registration failed");
		}

	}//
}
