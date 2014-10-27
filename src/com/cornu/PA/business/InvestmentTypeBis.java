package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.bean.InvestmentType;
import com.cornu.PA.user.bean.User;

public interface InvestmentTypeBis {
	
	public void add(InvestmentType investmentType);
	public void modify(InvestmentType investmentType);
	public InvestmentType getOneByID(int id);
	public List<InvestmentType> getALl(User user);
}
