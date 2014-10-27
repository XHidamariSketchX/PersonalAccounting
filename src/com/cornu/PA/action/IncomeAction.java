package com.cornu.PA.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;



import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.Balance;
import com.cornu.PA.bean.Income;
import com.cornu.PA.bean.IncomeCategory;
import com.cornu.PA.business.AccountBis;
import com.cornu.PA.business.AccountBisImpl;
import com.cornu.PA.business.BalanceBis;
import com.cornu.PA.business.BalanceBisImpl;
import com.cornu.PA.business.IncomeBis;
import com.cornu.PA.business.IncomeBisImpl;
import com.cornu.PA.business.IncomeCategoryBis;
import com.cornu.PA.business.IncomeCategoryBisImpl;
import com.cornu.PA.business.PaymentBis;
import com.cornu.PA.business.PaymentBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IncomeAction extends ActionSupport {
	private String id;
	private String IncomeCategory;
	private String account;
	private String oldAccount;
	private String amount;
	private String oldAmount;
	private String createtime;
	private String remarks;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIncomeCategory() {
		return IncomeCategory;
	}
	public void setIncomeCategory(String incomeCategory) {
		IncomeCategory = incomeCategory;
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private Income modifyAssemable(){
		//创建Income实例
		Income income=new Income(); 
		//从session获取登录用户
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		try{
			income.setUser(user);
			//设置要修改的标识
			income.setId(Integer.parseInt(this.getId()));
			//设置账户
			Account account=new Account();
			account.setId(Integer.parseInt(this.getAccount()));
			income.setAccount(account);
			//设置金额
			income.setAmount(new Float(this.getAmount()));
			//时间
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createTime=df.parse(this.getCreatetime());
			income.setCreateTime(createTime);
			//设置收入分类
			IncomeCategory incomeCategory=new IncomeCategory();
			incomeCategory.setId(Integer.parseInt(this.getIncomeCategory()));
			income.setIncomeCategory(incomeCategory);
			//备注
			income.setRemarks(this.getRemarks());
			return income;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	private Income addAssemable(){
		//创建Income实例
		Income income=new Income(); 
		//从session获取登录用户
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		try{
			income.setUser(user);
			//设置账户
			Account account=new Account();
			account.setId(Integer.parseInt(this.getAccount()));
			income.setAccount(account);
			//设置金额
			income.setAmount(new Float(this.getAmount()));
			//时间
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createTime=df.parse(this.getCreatetime());
			income.setCreateTime(createTime);
			//设置收入分类
			IncomeCategory incomeCategory=new IncomeCategory();
			incomeCategory.setId(Integer.parseInt(this.getIncomeCategory()));
			income.setIncomeCategory(incomeCategory);
			//备注
			income.setRemarks(this.getRemarks());
			return income;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public String incomeInit(){
		ActionContext ctx=ActionContext.getContext();
		Map request=(Map) ctx.get("request");
		User user=(User)ctx.getSession().get("loginuser");
		
		IncomeBis incomeBis=new IncomeBisImpl();
		IncomeCategoryBis icBis=new IncomeCategoryBisImpl();
		AccountBis accountBis=new AccountBisImpl();
		
		
		List<Income> incomeList=incomeBis.getAll(user);
		List<IncomeCategory> icList=icBis.getAll(user);
		List<Account> accountList=accountBis.getAll(user);
		
		
		request.put("incomeList", incomeList);
		request.put("icList", icList);
		request.put("accountList", accountList);
		request.put("currentTime", new Date());
		
		return SUCCESS;
	}
	public String add(){
		Income income=this.addAssemable();
		if(income!=null){
			IncomeBis incomeBis=new IncomeBisImpl();
			incomeBis.add(income);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	public String modifyInit(){
		try {
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			User user=(User)ctx.getSession().get("loginuser");
			
			IncomeBis incomeBis=new IncomeBisImpl();
			IncomeCategoryBis icBis=new IncomeCategoryBisImpl();
			AccountBis accountBis=new AccountBisImpl();
			
			Income income=incomeBis.getOneByID(Integer.parseInt(this.getId()));
			List<IncomeCategory> icList=icBis.getAll(user);
			List<Account> accountList=accountBis.getAll(user);
			request.put("income", income);
			request.put("icList", icList);
			request.put("accountList", accountList);
		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		return SUCCESS;
	}
	public String modify(){
		Income income=this.modifyAssemable();
		if(income!=null){
			//创建Income业务层
			IncomeBis incomeBis=new IncomeBisImpl();
			//获取修改前的账户ID
			int oldAccountID=Integer.parseInt(this.getOldAccount());
			//获取修改前的支付金额
			Float oldAmount=new Float(this.getOldAmount());
			//判断是否有账户变化
				//账户不变
			if(oldAccountID==income.getAccount().getId()){
				incomeBis.modify(oldAmount, income);
			}	//账户改变
			else{	
				incomeBis.modify(oldAccountID, oldAmount, income);
			}
			return SUCCESS;
		}
		return ERROR;			
	}	
	public String remove(){
		try {
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			User user=(User)ctx.getSession().get("loginuser");
			IncomeBis incomeBis=new IncomeBisImpl();
			incomeBis.remove(user, Integer.parseInt(id));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String search(){
		try {
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			User user=(User)ctx.getSession().get("loginuser");
			
			IncomeBis incomeBis=new IncomeBisImpl();
			IncomeCategoryBis icBis=new IncomeCategoryBisImpl();
			AccountBis accountBis=new AccountBisImpl();
			
			
			List<Income> incomeList=incomeBis.search(user, Integer.parseInt(this.getIncomeCategory()), Integer.parseInt(this.getAccount()));
			List<IncomeCategory> icList=icBis.getAll(user);
			List<Account> accountList=accountBis.getAll(user);
			
			
			request.put("incomeList", incomeList);
			request.put("icList", icList);
			request.put("accountList", accountList);
			request.put("currentTime", new Date());
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
}
