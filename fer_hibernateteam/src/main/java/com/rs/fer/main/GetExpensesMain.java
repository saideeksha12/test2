
package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();
		int userid = 2;
		List<Expense> expenses = ferservice.getExpenses(userid);
		if (expenses == null) {
			System.out.println("expense fetched failed:");
		} else {
			for (Expense expense : expenses) {
				System.out.println("expense:" + expense.getExpensetype() + "," + expense.getBywhom() + ","
						+ expense.getPrice() + "," + expense.getNoofItems() + "," + expense.getTotal() + ","
						+ expense.getBywhom() + "," + expense.getUserid());
			}
		}

	}

}
