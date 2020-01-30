package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setExpensetype("bergers");
		expense.setDate("30/01/2020");
		expense.setPrice(500);
		expense.setNoofItems(2);
		expense.setTotal(1000);
		expense.setBywhom("anu");
		expense.setUserid(1);

		boolean isAddExpenseRec = ferservice.addExpense(expense);

		if (isAddExpenseRec) {
			System.out.println("Expense added successfully");
		} else {
			System.out.println("please try again later...");
		}

	}

}
