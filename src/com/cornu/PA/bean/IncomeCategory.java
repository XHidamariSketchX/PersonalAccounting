package com.cornu.PA.bean;

import com.cornu.PA.user.bean.User;

public class IncomeCategory {
	private int id;
	private String incomeCategoryName;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIncomeCategoryName() {
		return incomeCategoryName;
	}
	public void setIncomeCategoryName(String incomeCategoryName) {
		this.incomeCategoryName = incomeCategoryName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
