
package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setId(2);
		expense.setExpensetype("co");
		expense.setDate("26/12/2019");
		expense.setPrice(400);
		expense.setNoofItems(2);
		expense.setTotal(300);
		expense.setBywhom("jen");
		expense.setUserid(2);

		boolean isEditExpense = ferservice.editExpense(expense);
		if (isEditExpense) {
			System.out.println("expense edited successfully");
		} else {
			System.out.println("please try again later...");
		}

	}

}
