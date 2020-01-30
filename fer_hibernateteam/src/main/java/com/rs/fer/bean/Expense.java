package com.rs.fer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "Expense")
public class Expense {

	@Id
	@Column(updatable = false, nullable = false)
	@GeneratedValue
	private int Id;
	@Column
	private String Expensetype;
	@Column
	private String Date;
	@Column
	private float Price;
	@Column
	private int NoofItems;
	@Column
	private float Total;
	@Column
	private String Bywhom;
	@Column
	private int userid;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getExpensetype() {
		return Expensetype;
	}

	public void setExpensetype(String expensetype) {
		Expensetype = expensetype;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getNoofItems() {
		return NoofItems;
	}

	public void setNoofItems(int noofItems) {
		NoofItems = noofItems;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

	public String getBywhom() {
		return Bywhom;
	}

	public void setBywhom(String bywhom) {
		Bywhom = bywhom;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}