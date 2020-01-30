package com.rs.fer.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.HBUtil;

public class FERServiceImpl implements FERService {

	public boolean registration(User user) {
		boolean isRegister = false;
		try {
			Integer noOfRecInserted = (Integer) HBUtil.getSession().save(user);
			HBUtil.getTransactionCommit();
			System.out.println("No of Records Inserted:" + noOfRecInserted);
			isRegister = (noOfRecInserted > 0);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			HBUtil.closeSession();
		}

		return isRegister;
	}

	public boolean login(String userName, String password) {
		boolean isLogin = false;
		try {

			isLogin = HBUtil.getSession().createQuery("from User u  where u.username=? and u.password=?")
					.setParameter(0, userName).setParameter(1, password).list().stream().iterator().hasNext();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}
		return isLogin;

	}

	public boolean addExpense(Expense expense) {
		int isAddExpenseRec = 0;

		try {

			isAddExpenseRec = (Integer) HBUtil.getSession().save(expense);
			HBUtil.getTransactionCommit();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}

		return isAddExpenseRec > 0;
	}

	public boolean editExpense(Expense expense) {
		boolean isEditExpense = false;

		Session session = HBUtil.getSession();

		try {

			session.update(expense);
			HBUtil.getTransactionCommit();
			isEditExpense = true;

		} catch (Exception e) {
			isEditExpense = true;

			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}
		return isEditExpense;
	}


	public boolean deleteExpense(int expenseId) {
		boolean isDeleted = false;
		Session session = HBUtil.getSession();

		try {
			Expense expense = (Expense) session.load(Expense.class, new Integer(expenseId));
			session.delete(expense);
			HBUtil.getTransactionCommit();
			isDeleted = true;
		} catch (Exception e) {
			isDeleted = false;
			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}

		return isDeleted;
	}

	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		boolean isReset = false;
		Session session = HBUtil.getSession();
		try {

			User user = (User) session.load(User.class, userId);
			if (currentPassword.equals(user.getPassword())) {
				user.setPassword(newPassword);
				HBUtil.getTransactionCommit();
				isReset = true;
			}
			System.out.println(newPassword + "," + userId + "," + currentPassword);

		} catch (Exception e) {
			isReset = false;
			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}
		return isReset;
	}

	public Expense getExpense(int expenseId) {
		Session session = HBUtil.getSession();
		Expense expense = null;
		try {

			expense = (Expense) session.load(Expense.class, expenseId);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}

		return expense;
	}

	public List<Expense> getExpenses(int userId) {
		Session session = HBUtil.getSession();
		Transaction transaction = null;
		List<Expense> expenses = new ArrayList<Expense>();
		try {

			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM Expense WHERE userId=?");
			query.setParameter(0, userId);
			transaction.commit();
			return query.list();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}
		return expenses;

	}

	@SuppressWarnings("unchecked")
	public List<Expense> getExpenseReport(int userId, String expenseType, String fromDate, String toDate) {
		List<Expense> expenseReport = new ArrayList<Expense>();

		try {

			HBUtil.getSession().createQuery("from Expense e where userId=? and expenseType=? and date between ? and ?")
					.setParameter(0,userId).setParameter(1, expenseType).setParameter(2, fromDate).setParameter(3, toDate).list().stream()
					.forEach(expense -> {
						expenseReport.addAll((Collection<? extends Expense>) expense);
					});

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}
		return expenseReport;
	}

	@Override
	public User getUser(int userId) {
		User user = new User();

		try {
			Query setParameter = HBUtil.getSession()
					.createQuery("FROM User u LEFT JOIN Address a ON u.id=a.userid WHERE u.id=?")
					.setParameter(1, userId);
			List list = setParameter.list();
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				user = (User) iterator.next();
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}

		return user;
	}

	public boolean updateUser(User user) {
		boolean isUpdate = false;

		try {
			HBUtil.getSession().saveOrUpdate(user);
			HBUtil.getTransactionCommit();
			isUpdate = true;

		} catch (Exception e) {
			isUpdate = false;
			e.printStackTrace();

		} finally {
			HBUtil.closeSession();
		}
		return isUpdate;
	}

}
