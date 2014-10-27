package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.bean.Budget;
import com.cornu.PA.user.bean.User;


public interface BudgetBis {
	public void add(Budget budget);
	public void modify(Budget budget);
	public Budget getOneByID(int id);
	public List<Budget> getALl(User user);
	public void achieve(Budget budget);
	public void remove(Budget budget);
}
