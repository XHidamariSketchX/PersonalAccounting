package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.bean.Investment;
import com.cornu.PA.bean.InvestmentType;
import com.cornu.PA.user.bean.User;

public interface InvestmentBis {
	public void add(Investment investment);
	public void modify(Investment investment);
	public Investment getOneByID(int id);
	public List<Investment> getALl(User user);
	public void payback(Investment investment);
	public void remove(User user,int id);
}
