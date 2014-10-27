package com.cornu.PA.action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cornu.PA.bean.Budget;
import com.cornu.PA.business.BudgetBis;
import com.cornu.PA.business.BudgetBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BudgetAction extends ActionSupport {
	private String id;
	private String application;
	private String place;
	private String amount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String budgetInit(){
		//获取登录用户
		ActionContext ctx=ActionContext.getContext();
		User user=(User)ctx.getSession().get("loginuser");
		Map request=(Map)ctx.get("request");
		//创建业务层
		BudgetBis budgetBis=new BudgetBisImpl();
		//获取列表
		List<Budget> budgetList=budgetBis.getALl(user);
		//存入request
		request.put("budgetList", budgetList);
		return SUCCESS;
	}
	public String add(){
		try {
			//获取登录用户
			ActionContext ctx=ActionContext.getContext();
			User user=(User)ctx.getSession().get("loginuser");
			//创建业务层
			BudgetBis budgetBis=new BudgetBisImpl();
			//通过页面传递参数勾结Budget对象
			Budget budget=new Budget();
			budget.setAmount(new Float(this.getAmount()));
			budget.setApplication(application);
			budget.setCreateTime(new Date());
			budget.setPlace(place);
			budget.setState(Budget.NEW);
			budget.setUser(user);
			//添加
			budgetBis.add(budget);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	public String achieve(){
		try {
			BudgetBis budgetBis=new BudgetBisImpl();
			Budget budget=budgetBis.getOneByID(Integer.parseInt(this.getId()));
			budgetBis.achieve(budget);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public String remove(){
		try {
			BudgetBis budgetBis=new BudgetBisImpl();
			Budget budget=budgetBis.getOneByID(Integer.parseInt(this.getId()));
			budgetBis.remove(budget);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
}
