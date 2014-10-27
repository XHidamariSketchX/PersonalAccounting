package com.cornu.PA.bean;

import com.cornu.PA.user.bean.User;

public class PaymentCategory {
	private int id;
	private String paymentCategoryName;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentCategoryName() {
		return paymentCategoryName;
	}
	public void setPaymentCategoryName(String paymentCategoryName) {
		this.paymentCategoryName = paymentCategoryName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
