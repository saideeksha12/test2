
package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LoginMain {

	public static void main(String args[]) {

		FERService ferService = new FERServiceImpl();

		boolean login = ferService.login("admin", "1234");

		if (login) {
			System.out.println("Logged in successfully");
		} else {
			System.out.println("Login failed");
		}

	}

}
