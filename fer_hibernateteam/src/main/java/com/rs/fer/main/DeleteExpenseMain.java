package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();

		boolean isDelete = ferservice.deleteExpense(2);
		if (isDelete) {
			System.out.println("expense deleted successfully");
		} else {
			System.out.println("please try again later...");
		}

	}

}
