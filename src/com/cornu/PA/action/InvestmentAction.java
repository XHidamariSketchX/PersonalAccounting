package com.cornu.PA.action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.Investment;
import com.cornu.PA.bean.InvestmentType;
import com.cornu.PA.bean.Payment;
import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.business.AccountBis;
import com.cornu.PA.business.AccountBisImpl;
import com.cornu.PA.business.InvestmentBis;
import com.cornu.PA.business.InvestmentBisImpl;
import com.cornu.PA.business.InvestmentTypeBis;
import com.cornu.PA.business.InvestmentTypeBisImpl;
import com.cornu.PA.business.PaymentBis;
import com.cornu.PA.business.PaymentBisImpl;
import com.cornu.PA.business.PaymentCategoryBis;
import com.cornu.PA.business.PaymentCategoryBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InvestmentAction extends ActionSupport {
	private String id;
	private String investmentType;
	private String amount;
	private String expectedReturn;
	private String createtime;
	private String returnTime;
	private String remarks;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInvestmentType() {
		return investmentType;
	}
	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getExpectedReturn() {
		return expectedReturn;
	}
	public void setExpectedReturn(String expectedReturn) {
		this.expectedReturn = expectedReturn;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	private Investment assamble(){
		//创建Investment实例
		Investment investment=new Investment();
		//从session获取登录用户
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		try {
			investment.setUser(user);
			//设置投资类型
			InvestmentType investmentType=new InvestmentType();
			investmentType.setId(Integer.parseInt(this.getInvestmentType()));
			investment.setInvestmentType(investmentType);
			//设置投资金额
			investment.setAmount(new Float(this.getAmount()));
			//设置预计回报金额
			if(this.getExpectedReturn()==null||this.getExpectedReturn().equals("")){
				investment.setExpectedReturn(null);
			}
			else{
				investment.setExpectedReturn(new Float(this.getExpectedReturn()));
			}
			//设置投资时间
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createTime=df.parse(this.getCreatetime());
			investment.setCreateTime(createTime);
			//设置预计回报时间
			if(this.getReturnTime()==null||this.getReturnTime().trim().equals("")){
				investment.setReturnTime(null);
			}
			else{
				Date returnTime=df.parse(this.getReturnTime());
				investment.setReturnTime(returnTime);
			}
			
			investment.setRemarks(this.getRemarks());
			investment.setState(Investment.NEW);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return investment;
	}
	public String investmentInit(){
		//获取登录用户
		ActionContext ctx=ActionContext.getContext();
		Map request=(Map) ctx.get("request");
		User user=(User)ctx.getSession().get("loginuser");
		//创建业务层
		InvestmentTypeBis itBis=new InvestmentTypeBisImpl();
		InvestmentBis investmentBis=new InvestmentBisImpl();
		//获取分类 和投资列表
		List<InvestmentType> itList=itBis.getALl(user);
		List<Investment> investmentList=investmentBis.getALl(user);
		//结果放入request
		request.put("itList", itList);
		request.put("investmentList", investmentList);
		request.put("currentDate", new Date());
		return SUCCESS;
	}
	public String add(){
		//由页面传递参数构建Investment对象
		Investment investment=this.assamble();
		//构建成功
		if(investment!=null){
			//创建业务层
			InvestmentBis investmentBis=new InvestmentBisImpl();
			//添加
			investmentBis.add(investment);
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
			InvestmentTypeBis itBis=new InvestmentTypeBisImpl();
			InvestmentBis investmentBis=new InvestmentBisImpl();
			//通过参数id获取指定对象
			Investment investment=investmentBis.getOneByID(Integer.parseInt(this.getId()));
			//获取分类
			List<InvestmentType> itList=itBis.getALl(user);
			//结果存入request
			request.put("investment", investment);
			request.put("itList", itList);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}	
		
	}
	public String remove(){
		try {
			//获取登录用户
			ActionContext ctx=ActionContext.getContext();
			Map request=(Map) ctx.get("request");
			User user=(User)ctx.getSession().get("loginuser");
			//创建业务层
			InvestmentBis investmentBis=new InvestmentBisImpl();
			//删除指定id对象
			investmentBis.remove(user, Integer.parseInt(id));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	public String modify(){
		//由页面传递参数构建Investment对象
		Investment investment=this.assamble();
		investment.setId(Integer.parseInt(this.getId()));
		//构建成功
		if(investment!=null){
			//创建业务层
			InvestmentBis investmentBis=new InvestmentBisImpl();
			//添加
			investmentBis.modify(investment);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
}
