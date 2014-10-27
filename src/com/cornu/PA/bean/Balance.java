package com.cornu.PA.bean;

import com.cornu.PA.user.bean.User;

public class Balance {
 private int id;
 private float totalPayment;
 private float totalIncome;
 private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getTotalPayment() {
	return totalPayment;
}
public void setTotalPayment(float totalPayment) {
	this.totalPayment = totalPayment;
}
public float getTotalIncome() {
	return totalIncome;
}
public void setTotalIncome(float totalIncome) {
	this.totalIncome = totalIncome;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}
