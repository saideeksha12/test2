
package com.rs.fer.main;

import java.util.Optional;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();
		int userid = 3;
		User user = ferservice.getUser(userid);
		Optional<User> isExistence = Optional.ofNullable(user);
		if (isExistence.isPresent()) {
			System.out.println(user.getEmailId());
			System.out.println("Record Fetched Successful");
		} else {
			System.out.println("Records fetching failed");
		}

	}
}