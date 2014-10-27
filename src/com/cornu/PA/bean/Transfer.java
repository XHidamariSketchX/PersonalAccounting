package com.cornu.PA.bean;


import java.util.Date;

import com.cornu.PA.user.bean.User;

public class Transfer {
private int id;
private Account outAccount;
private Account inAccount;
private Float amount;
private Date createTime;
private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public Account getOutAccount() {
	return outAccount;
}
public void setOutAccount(Account outAccount) {
	this.outAccount = outAccount;
}
public Account getInAccount() {
	return inAccount;
}
public void setInAccount(Account inAccount) {
	this.inAccount = inAccount;
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
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
