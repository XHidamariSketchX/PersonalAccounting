package com.cornu.PA.bean;

import java.math.BigDecimal;

import com.cornu.PA.user.bean.User;

public class Account {
	public static int NORMAL=1;
	public static int INVESTMENT=2;
	private int id;
	private String accountName;
	private Float balance;
	private int type=NORMAL;
	private User user;
	public static int getNORMAL() {
		return NORMAL;
	}
	public static void setNORMAL(int nORMAL) {
		NORMAL = nORMAL;
	}
	public static int getINVESTMENT() {
		return INVESTMENT;
	}
	public static void setINVESTMENT(int iNVESTMENT) {
		INVESTMENT = iNVESTMENT;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
