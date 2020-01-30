
package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();

		boolean isReset = ferservice.resetPassword(1, "karthik1", "naga1");

		if (isReset) {
			System.out.println("password changed successfully");
		} else {
			System.out.println("password reset failed");
		}

	}

}
