package com.cornu.PA.bean;


import java.util.Date;

import com.cornu.PA.user.bean.User;

public class Investment {
	public static int NEW=1;
	public static int ON=2;
	public static int FINISH=3;
	private int id;
	private InvestmentType investmentType;
	private Date createTime;
	private Date returnTime;
	private Float amount;
	private Float expectedReturn;
	private Float actualReturn;
	private int state;
	private String remarks;
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InvestmentType getInvestmentType() {
		return investmentType;
	}
	public void setInvestmentType(InvestmentType investmentType) {
		this.investmentType = investmentType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	public Float getExpectedReturn() {
		return expectedReturn;
	}
	public void setExpectedReturn(Float expectedReturn) {
		this.expectedReturn = expectedReturn;
	}
	public Float getActualReturn() {
		return actualReturn;
	}
	public void setActualReturn(Float actualReturn) {
		this.actualReturn = actualReturn;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
