package com.cornu.PA.action;

import java.util.List;
import java.util.Map;

import com.cornu.PA.bean.IncomeCategory;
import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.business.IncomeCategoryBis;
import com.cornu.PA.business.IncomeCategoryBisImpl;
import com.cornu.PA.business.PaymentCategoryBis;
import com.cornu.PA.business.PaymentCategoryBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	private String id;
	private String paymentCategoryName;
	private String incomeCategoryName;	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPaymentCategoryName() {
		return paymentCategoryName;
	}
	public void setPaymentCategoryName(String paymentCategoryName) {
		this.paymentCategoryName = paymentCategoryName;
	}
	public String getIncomeCategoryName() {
		return incomeCategoryName;
	}
	public void setIncomeCategoryName(String incomeCategoryName) {
		this.incomeCategoryName = incomeCategoryName;
	}
	public String categoryInit(){
		ActionContext ctx=ActionContext.getContext();
		Map session=ctx.getSession();
		Map request=(Map) ctx.get("request");
		User user=(User)session.get("loginuser");
		
		PaymentCategoryBis pcBis=new PaymentCategoryBisImpl();
		IncomeCategoryBis icBis=new IncomeCategoryBisImpl();
		
		List<PaymentCategory> pcList=pcBis.getAll(user);
		List<IncomeCategory> icList=icBis.getAll(user);
		request.put("pcList", pcList);
		request.put("icList", icList);
		return SUCCESS;
	}
	public String paymentCategoryModify(){
		try {
			ActionContext ctx=ActionContext.getContext();
			User user=(User)ctx.getSession().get("loginuser");			
			PaymentCategory paymentCategory=new PaymentCategory();
			paymentCategory.setId(Integer.parseInt(this.getId()));
			paymentCategory.setPaymentCategoryName(this.getPaymentCategoryName());
			paymentCategory.setUser(user);
			PaymentCategoryBis paymentBis=new PaymentCategoryBisImpl();
			paymentBis.modify(paymentCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	public String paymentCategoryModifyInit()
	{
		Map request=(Map)ActionContext.getContext().get("request");
		PaymentCategoryBis pcBis=new PaymentCategoryBisImpl();
		PaymentCategory paymentCategory=pcBis.getOneByID(Integer.parseInt(this.getId()));
		request.put("paymentCategory", paymentCategory);
		return SUCCESS;
	}
	public String paymentCategoryAdd(){
		PaymentCategory paymentCategory=new PaymentCategory();
		paymentCategory.setPaymentCategoryName(paymentCategoryName);
		ActionContext ctx=ActionContext.getContext();
		User user=(User)ctx.getSession().get("loginuser");
		paymentCategory.setUser(user);
		PaymentCategoryBis pcBis=new PaymentCategoryBisImpl();
		pcBis.add(paymentCategory);
		return SUCCESS;
	}
	public String incomeCategoryModify(){
		try {
			ActionContext ctx=ActionContext.getContext();
			User user=(User)ctx.getSession().get("loginuser");
			IncomeCategory incomeCategory=new IncomeCategory();
			incomeCategory.setId(Integer.parseInt(this.getId()));
			incomeCategory.setIncomeCategoryName(this.getIncomeCategoryName());
			incomeCategory.setUser(user);
			IncomeCategoryBis incomeBis=new IncomeCategoryBisImpl();
			incomeBis.modify(incomeCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String incomeCategoryModifyInit()
	{
		Map request=(Map)ActionContext.getContext().get("request");
		IncomeCategoryBis icBis=new IncomeCategoryBisImpl();
		IncomeCategory incomeCategory=icBis.getOneByID(Integer.parseInt(this.getId()));
		request.put("incomeCategory", incomeCategory);
		return SUCCESS;
	}
	public String incomeCateogryAdd()
	{
		IncomeCategory incomeCategory=new IncomeCategory();
		incomeCategory.setIncomeCategoryName(incomeCategoryName);
		ActionContext ctx=ActionContext.getContext();
		User user=(User)ctx.getSession().get("loginuser");
		incomeCategory.setUser(user);
		IncomeCategoryBis icBis=new IncomeCategoryBisImpl();
		icBis.add(incomeCategory);
		return SUCCESS;		
	}
}
