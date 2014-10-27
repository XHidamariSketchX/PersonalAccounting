package com.cornu.PA.bean;

import com.cornu.PA.user.bean.User;

public class InvestmentType {
	private int id;
	private String investmentTypeName;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInvestmentTypeName() {
		return investmentTypeName;
	}
	public void setInvestmentTypeName(String investmentTypeName) {
		this.investmentTypeName = investmentTypeName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
