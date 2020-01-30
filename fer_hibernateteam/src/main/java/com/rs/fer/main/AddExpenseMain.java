package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setExpensetype("Vegetables");
		expense.setDate("26/12/2019");
		expense.setPrice(100);
		expense.setNoofItems(2);
		expense.setTotal(200);
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
