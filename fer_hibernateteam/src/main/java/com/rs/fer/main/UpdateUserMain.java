package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();
		User user = new User();
		user.setFirstname("Navya");
		user.setMiddlename("Swamy");
		user.setLastname("M");
		user.setEmailId("dinesh@gmail.com");
		user.setMobileno("1245556660");
		user.setId(12);

		Address address = new Address();
		address.setId(8);
		address.setAddress1("Miyapur");
		address.setAddress2("Hyd");
		address.setStreet("Mahadevapuram Colony");
		address.setArea("Kphb");
		address.setCity("Hyderabad");
		address.setState("TG");
		address.setPincode(500049);
		address.setUserid(26);

		user.setAddress(address);
		boolean updateUser = ferservice.updateUser(user);
		if (updateUser) {

			System.out.println("User updated successfully");
		} else {
			System.out.println("Update failed");
		}

	}
}
