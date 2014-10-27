package com.cornu.PA.action;

import java.util.List;
import java.util.Map;

import com.cornu.PA.bean.InvestmentType;
import com.cornu.PA.business.InvestmentTypeBis;
import com.cornu.PA.business.InvestmentTypeBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InvestmentTypeAction extends ActionSupport {
	String id;
	String investmentTypeName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInvestmentTypeName() {
		return investmentTypeName;
	}
	public void setInvestmentTypeName(String investmentTypeName) {
		this.investmentTypeName = investmentTypeName;
	}
	public String investmentTypeInit(){
		ActionContext ctx=ActionContext.getContext();
		Map session=ctx.getSession();
		Map request=(Map) ctx.get("request");
		User user=(User)session.get("loginuser");
		
		
		InvestmentTypeBis itBis=new InvestmentTypeBisImpl();
		List<InvestmentType> itList=itBis.getALl(user);
		request.put("itList", itList);
		return SUCCESS;
	}
	public String add(){
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		InvestmentType investmentType=new InvestmentType();
		investmentType.setInvestmentTypeName(investmentTypeName);
		investmentType.setUser(user);
		InvestmentTypeBis icBis=new InvestmentTypeBisImpl();
		icBis.add(investmentType);
		return SUCCESS;
	}
	public String modifyInit(){
		Map request=(Map)ActionContext.getContext().get("request");
		try {
			InvestmentTypeBis investmentTypeBis=new InvestmentTypeBisImpl();
			InvestmentType investmentType=investmentTypeBis.getOneByID(Integer.parseInt(id));
			request.put("investmentType", investmentType);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	public String modify(){
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		InvestmentType investmentType=new InvestmentType();
		investmentType.setInvestmentTypeName(investmentTypeName);
		investmentType.setUser(user);
		investmentType.setId(Integer.parseInt(id));
		InvestmentTypeBis icBis=new InvestmentTypeBisImpl();
		icBis.modify(investmentType);
		return SUCCESS;
		
		
		
	}
}
