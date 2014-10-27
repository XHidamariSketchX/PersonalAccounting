package com.cornu.PA.action;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.Transfer;
import com.cornu.PA.business.AccountBis;
import com.cornu.PA.business.AccountBisImpl;
import com.cornu.PA.business.TransferBis;
import com.cornu.PA.business.TransferBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TransferAction extends ActionSupport {
	private String outAccount;
	private String inAccount;
	private String amount;
	private String createtime;
	public String getOutAccount() {
		return outAccount;
	}
	public void setOutAccount(String outAccount) {
		this.outAccount = outAccount;
	}
	public String getInAccount() {
		return inAccount;
	}
	public void setInAccount(String inAccount) {
		this.inAccount = inAccount;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String transferInit(){
		//获取Action上下文
		ActionContext ctx=ActionContext.getContext();
		//获取登录用户
		User user=(User)ctx.getSession().get("loginuser");
		//获取命名对象request
		Map request=(Map) ctx.get("request");
		//创建Transfer业务层
		TransferBis transferBis=new TransferBisImpl();
		//创建Account业务层
		AccountBis accountBis=new AccountBisImpl();
		//获取Transfer列表
		List<Transfer> transferList=transferBis.getAll(user);
		//获取Account列表
		List<Account> accountList=accountBis.getAll(user);
		//放入请求
		request.put("transferList", transferList);
		request.put("currentTime", new Date());
		request.put("accountList", accountList);
		return SUCCESS;
	}
	public String add(){
		User user=(User)ActionContext.getContext().getSession().get("loginuser");
		Transfer transfer=new Transfer();
		try {
			transfer.setUser(user);
			//设置金额
			transfer.setAmount(new Float(this.getAmount()));
			//设置转账时间
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date createTime=df.parse(this.getCreatetime());
			transfer.setCreateTime(createTime);
			//设置转入账户
			Account inAccount=new Account();
			inAccount.setId(Integer.parseInt(this.getInAccount()));
			transfer.setInAccount(inAccount);
			//设置转出账户
			Account outAccount=new Account();
			outAccount.setId(Integer.parseInt(this.getOutAccount()));
			transfer.setOutAccount(outAccount);
			//创建Transfer业务层
			TransferBis transferBis=new TransferBisImpl();
			//保存transfer
			transferBis.add(transfer);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
}
