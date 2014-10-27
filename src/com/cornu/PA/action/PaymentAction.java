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

public class PaymentAction extends ActionSupport {
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
	public Payment modifyAssemable(){
		//创建Payment实例
		Payment payment=new Payment(); 
		//从session获取登录用户
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		try {
			
			payment.setUser(user);
			//设置要修改的标识
			payment.setId(Integer.parseInt(this.getId()));
			//设置账户
			Account account=new Account();
			account.setId(Integer.parseInt(this.getAccount()));
			payment.setAccount(account);
			//设置类别
			PaymentCategory paymentCategory=new PaymentCategory();
			paymentCategory.setId(Integer.parseInt(this.getPaymentCategory()));
			payment.setPaymentCategory(paymentCategory);
			//设置金额
			payment.setAmount(new Float(this.getAmount()));
			//时间
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createTime=df.parse(this.getCreatetime());
			payment.setCreateTime(createTime);
			//商家
			payment.setPlace(this.getPlace());
			//备注
			payment.setRemarks(this.getRemarks());
			payment.setState(Payment.NEW);
			return payment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public Payment addAssemable(){
		//创建Payment实例
		Payment payment=new Payment(); 
		//从session获取登录用户
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		try {
			
			payment.setUser(user);
			//设置账户
			Account account=new Account();
			account.setId(Integer.parseInt(this.getAccount()));
			payment.setAccount(account);
			//设置类别
			PaymentCategory paymentCategory=new PaymentCategory();
			paymentCategory.setId(Integer.parseInt(this.getPaymentCategory()));
			payment.setPaymentCategory(paymentCategory);
			//设置金额
			payment.setAmount(new Float(this.getAmount()));
			//时间
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createTime=df.parse(this.getCreatetime());
			payment.setCreateTime(createTime);
			//商家
			payment.setPlace(this.getPlace());
			//备注
			payment.setRemarks(this.getRemarks());
			payment.setState(Payment.NEW);
			return payment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public String paymentInit(){
		//获取登录用户
		ActionContext ctx=ActionContext.getContext();
		Map request=(Map) ctx.get("request");
		User user=(User)ctx.getSession().get("loginuser");
		//创建业务层
		PaymentBis paymentBis=new PaymentBisImpl();
		PaymentCategoryBis pcBis=new PaymentCategoryBisImpl();
		AccountBis accountBis=new AccountBisImpl();
		
		//获取账户 分类 支出列表
		List<Payment> paymentList=paymentBis.getAll(user);
		
		List<PaymentCategory> pcList=pcBis.getAll(user);
		List<Account> accountList=accountBis.getAll(user);
		
		//将列表放入request
		request.put("paymentList", paymentList);
		request.put("pcList", pcList);
		request.put("accountList", accountList);
		//将当前时间放入request
		request.put("currentDate", new Date());
		
		return SUCCESS;
	}
	public String add(){
		//组装Payment实例
		Payment payment=this.addAssemable();
		if(payment!=null){
			//创建业务层
			PaymentBis paymentBis=new PaymentBisImpl();
			//保存Payment实例
			paymentBis.add(payment);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public String modifyInit(){
		try {
			//获取登录用户
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			User user=(User)ctx.getSession().get("loginuser");
			//创建业务层
			PaymentBis paymentBis=new PaymentBisImpl();
			PaymentCategoryBis pcBis=new PaymentCategoryBisImpl();
			AccountBis accountBis=new AccountBisImpl();
			//通过参数id获取Payment实例
			Payment payment=paymentBis.getOneByID(Integer.parseInt(this.getId()));
			//获取分类 账户列表
			List<PaymentCategory> pcList=pcBis.getAll(user);
			List<Account> accountList=accountBis.getAll(user);
			//结果放入request
			request.put("payment", payment);
			request.put("pcList", pcList);
			request.put("accountList", accountList);
		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		return SUCCESS;
	}
	public String modify(){
		Payment payment=this.modifyAssemable();
		if(payment!=null){
			PaymentBis paymentBis=new PaymentBisImpl();
			//获取修改前的账户ID
			int oldAccountID=Integer.parseInt(this.getOldAccount());
			//获取修改前的支付金额
			Float oldAmount=new Float(this.getOldAmount());
			//判断是否有账户变化
				//账户不变
			if(oldAccountID==payment.getAccount().getId()){
				paymentBis.modify(oldAmount, payment);
			}	//账户改变
			else{	
				paymentBis.modify(oldAccountID, oldAmount, payment);
			}
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
			PaymentBis paymentBis=new PaymentBisImpl();
			//删除指定id的Payment对象
			paymentBis.remove(user, Integer.parseInt(id));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public String addToHistoryPurchase(){
		try {
			//创建业务层
			PaymentBis paymentBis=new PaymentBisImpl();
			HistoryPurchaseBis hpBis=new HistoryPurchaseBisImpl();
			//通过id获取
			Payment p=paymentBis.getOneByID(Integer.parseInt(id));
			p.setState(Payment.ADDED_TO_HISTORYPURCHSASE);
			paymentBis.modify(p);
			//创建历史购买对象
			HistoryPurchase hp=new HistoryPurchase();
			//设置属性
			hp.setAccount(p.getAccount());
			hp.setAmount(p.getAmount());
			hp.setCreateTime(p.getCreateTime());
			hp.setPaymentCategory(p.getPaymentCategory());
			hp.setPlace(p.getPlace());
			hp.setRemarks(p.getRemarks());
			
			hp.setUser(p.getUser());
			//添加历史购买
			hpBis.add(hp);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String search(){
		try {
			//获取登录用户
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			User user=(User)ctx.getSession().get("loginuser");
			//创建业务层
			PaymentBis paymentBis=new PaymentBisImpl();
			PaymentCategoryBis pcBis=new PaymentCategoryBisImpl();
			AccountBis accountBis=new AccountBisImpl();
			
			//获取账户 分类 支出列表
			List<Payment> paymentList=paymentBis.search(user, Integer.parseInt(this.getPaymentCategory()), Integer.parseInt(this.getAccount()));
			List<PaymentCategory> pcList=pcBis.getAll(user);
			List<Account> accountList=accountBis.getAll(user);
			
			//将列表放入request
			request.put("paymentList", paymentList);
			request.put("pcList", pcList);
			request.put("accountList", accountList);
			//将当前时间放入request
			request.put("currentDate", new Date());
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
			
	}
}
