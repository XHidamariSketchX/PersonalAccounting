package com.cornu.PA.action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.HistoryPurchase;
import com.cornu.PA.bean.Payment;
import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.business.AccountBis;
import com.cornu.PA.business.AccountBisImpl;
import com.cornu.PA.business.HistoryPurchaseBis;
import com.cornu.PA.business.HistoryPurchaseBisImpl;
import com.cornu.PA.business.PaymentBis;
import com.cornu.PA.business.PaymentBisImpl;
import com.cornu.PA.business.PaymentCategoryBis;
import com.cornu.PA.business.PaymentCategoryBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HistoryPurchaseAction extends ActionSupport {
	private String id;
	private String paymentCategory;
	private String account;
	private String oldAccount;
	private String amount;
	private String oldAmount;
	private String createtime;
	private String place;
	private String remarks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPaymentCategory() {
		return paymentCategory;
	}
	public void setPaymentCategory(String paymentCategory) {
		this.paymentCategory = paymentCategory;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getOldAccount() {
		return oldAccount;
	}
	public void setOldAccount(String oldAccount) {
		this.oldAccount = oldAccount;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getOldAmount() {
		return oldAmount;
	}
	public void setOldAmount(String oldAmount) {
		this.oldAmount = oldAmount;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private HistoryPurchase modifyAssemable(){
		//创建Payment实例
		HistoryPurchase hp=new HistoryPurchase(); 
		//从session获取登录用户
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		try {
			
			hp.setUser(user);
			//设置要修改的标识
			hp.setId(Integer.parseInt(this.getId()));
			//设置账户
			Account account=new Account();
			account.setId(Integer.parseInt(this.getAccount()));
			hp.setAccount(account);
			//设置类别
			PaymentCategory paymentCategory=new PaymentCategory();
			paymentCategory.setId(Integer.parseInt(this.getPaymentCategory()));
			hp.setPaymentCategory(paymentCategory);
			//设置金额
			hp.setAmount(new Float(this.getAmount()));
			//时间
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createTime=df.parse(this.getCreatetime());
			hp.setCreateTime(createTime);
			//商家
			hp.setPlace(this.getPlace());
			//备注
			hp.setRemarks(this.getRemarks());
			return hp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	private HistoryPurchase addAssemable(){
		//创建Payment实例
		HistoryPurchase historyPurchase=new HistoryPurchase(); 
		//从session获取登录用户
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		try {
			
			historyPurchase.setUser(user);
			//设置账户
			Account account=new Account();
			account.setId(Integer.parseInt(this.getAccount()));
			historyPurchase.setAccount(account);
			//设置类别
			PaymentCategory paymentCategory=new PaymentCategory();
			paymentCategory.setId(Integer.parseInt(this.getPaymentCategory()));
			historyPurchase.setPaymentCategory(paymentCategory);
			//设置金额
			historyPurchase.setAmount(new Float(this.getAmount()));
			//时间
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createTime=df.parse(this.getCreatetime());
			historyPurchase.setCreateTime(createTime);
			//商家
			historyPurchase.setPlace(this.getPlace());
			//备注
			historyPurchase.setRemarks(this.getRemarks());
			return historyPurchase;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public String add(){
		//组装Payment实例
		HistoryPurchase historyPurchase=this.addAssemable();
		if(historyPurchase!=null){
			//创建业务层
			HistoryPurchaseBis hpBis=new HistoryPurchaseBisImpl();
			//保存Payment实例
			hpBis.add(historyPurchase);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public String historyPurchaseInit(){
		
		ActionContext ctx=ActionContext.getContext();
		Map request=(Map) ctx.get("request");
		User user=(User)ctx.getSession().get("loginuser");
		
		HistoryPurchaseBis hpBis=new HistoryPurchaseBisImpl();
		PaymentCategoryBis pcBis=new PaymentCategoryBisImpl();
		AccountBis accountBis=new AccountBisImpl();
		
		
		List<HistoryPurchase> paymentList=hpBis.getAll(user);
		List<PaymentCategory> pcList=pcBis.getAll(user);
		List<Account> accountList=accountBis.getAll(user);
		
		
		request.put("hpList", paymentList);
		request.put("pcList", pcList);
		request.put("accountList", accountList);
		request.put("currentDate", new Date());
		return SUCCESS;
	}
	public String modifyInit(){
		try {
			//获取登录用户
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			User user=(User)ctx.getSession().get("loginuser");
			//创建业务层
			HistoryPurchaseBis hpBis=new HistoryPurchaseBisImpl();
			PaymentCategoryBis pcBis=new PaymentCategoryBisImpl();
			AccountBis accountBis=new AccountBisImpl();
			//通过参数id获取HistoryPurchase实例
			HistoryPurchase hp=hpBis.getOnebyID(user, Integer.parseInt(this.getId()));
			//获取分类 账户列表
			List<PaymentCategory> pcList=pcBis.getAll(user);
			List<Account> accountList=accountBis.getAll(user);
			//结果放入request
			request.put("hp",hp);
			request.put("pcList", pcList);
			request.put("accountList", accountList);
		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		return SUCCESS;
	}
	public String modify(){
		HistoryPurchase hp=this.modifyAssemable();
		if(hp!=null){
			HistoryPurchaseBis hpBis=new HistoryPurchaseBisImpl();
			hpBis.modify(hp);
			return SUCCESS;
		}
		else
			return ERROR;
	}
	public String remove(){
		try {
			//获取登录用户
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			User user=(User)ctx.getSession().get("loginuser");
			//创建业务层
			HistoryPurchaseBis hpBis=new HistoryPurchaseBisImpl();
			HistoryPurchase hp=hpBis.getOnebyID(user, Integer.parseInt(this.getId()));
			hpBis.remove(hp);
			return SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}
		
	}
}
