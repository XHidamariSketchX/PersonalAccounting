package com.cornu.PA.action;

import java.util.List;
import java.util.Map;

import com.cornu.PA.bean.Account;
import com.cornu.PA.business.AccountBis;
import com.cornu.PA.business.AccountBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
	private String id;
	private String accountName;
	private String balance;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String add()
	{
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		Account account=new Account();
		try {
			account.setUser(user);
			account.setAccountName(accountName);
			account.setBalance(new Float(this.getBalance()));
			account.setType(Account.NORMAL);
			AccountBis accountBis=new AccountBisImpl();
			accountBis.add(account);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public String addInvestmentAccount()
	{
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		Account account=new Account();
		try {
			account.setUser(user);
			account.setAccountName(accountName);
			account.setBalance(new Float(this.getBalance()));
			account.setType(Account.INVESTMENT);
			AccountBis accountBis=new AccountBisImpl();
			accountBis.add(account);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public String modify()
	{
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		Account account=new Account();
		try {
			account.setId(Integer.parseInt(this.getId()));
			account.setUser(user);
			account.setAccountName(accountName);
			account.setBalance(new Float(this.getBalance()));
			account.setType(Account.NORMAL);
			AccountBis accountBis=new AccountBisImpl();
			accountBis.modify(account);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public String accountModify()
	{
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		Account account=new Account();
		try {
			account.setId(Integer.parseInt(this.getId()));
			account.setUser(user);
			account.setAccountName(accountName);
			account.setBalance(new Float(this.getBalance()));
			account.setType(Account.INVESTMENT);
			AccountBis accountBis=new AccountBisImpl();
			accountBis.modify(account);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public String modifyInit(){
		Map request=(Map)ActionContext.getContext().get("request");
		AccountBis accountBis=new AccountBisImpl();
		Account account=accountBis.getOneByID(Integer.parseInt(this.getId()));
		try {

			request.put("account", account);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public String accountInit(){
		ActionContext ctx=ActionContext.getContext();
		Map request=(Map) ctx.get("request");
		User user=(User)ctx.getSession().get("loginuser");		
		AccountBis accountBis=new AccountBisImpl();
		List<Account> accountList=accountBis.getAll(user);
		request.put("accountList", accountList);
		return SUCCESS;
	}
	public String investmentAccountInit(){
		ActionContext ctx=ActionContext.getContext();
		Map request=(Map) ctx.get("request");
		User user=(User)ctx.getSession().get("loginuser");		
		AccountBis accountBis=new AccountBisImpl();
		List<Account> accountList=accountBis.getAllInvestmentAccount(user);
		request.put("accountList", accountList);
		return SUCCESS;
	}
}
