
package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ExpenseReportMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userId = 1;
		String expenseType = "Vegetables";
		String fromDate = "24-12-2019";
		String toDate = "26-12-2019";
		List<Expense> expense = ferService.getExpenseReport(userId, expenseType, fromDate, toDate);

	}

}
