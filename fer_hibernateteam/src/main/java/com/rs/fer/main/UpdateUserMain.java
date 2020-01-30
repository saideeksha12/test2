package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setId(1);
		user.setFirstname("sai");
		user.setMiddlename("pavan");
		user.setLastname("r");
		user.setEmailId("rs@gamil.com");
		user.setMobileno("122637373");

		Address address = new Address();
		address.setId(3);
		address.setAddress1("madhapur");
		address.setAddress2("hyd");
		address.setCity("HYD");
		address.setState("TS");
		address.setPincode(6374789);
		address.setUserid(2);

		user.setAddress(address);
		boolean updatePersonal = ferService.updateUser(user);
		if (updatePersonal) {
			System.out.println("successfully...");
		} else {
			System.out.println("Failed..");
		}

	}

}
