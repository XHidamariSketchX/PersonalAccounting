package com.cornu.PA.bean;

import java.util.Date;

import com.cornu.PA.user.bean.User;

public class Income {
private int id;
private IncomeCategory incomeCategory;
private Account account;
private Float amount;
private Date createTime;
private String remarks;
private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public IncomeCategory getIncomeCategory() {
	return incomeCategory;
}
public void setIncomeCategory(IncomeCategory incomeCategory) {
	this.incomeCategory = incomeCategory;
}
public Account getAccount() {
	return account;
}
public void setAccount(Account account) {
	this.account = account;
}
public Float getAmount() {
	return amount;
}
public void setAmount(Float amount) {
	this.amount = amount;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
