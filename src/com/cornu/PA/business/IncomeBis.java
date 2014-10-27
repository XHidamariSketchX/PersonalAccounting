package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.bean.Income;
import com.cornu.PA.bean.Payment;
import com.cornu.PA.user.bean.User;

public interface IncomeBis {
	public void add(Income income);
	public void modify(Income income);
	public void modify(Float oldAmount,Income income);
	public void modify(int oldAccountID,Float oldAmount,Income income);
	public Income getOneByID(int id);
	public List<Income> getAll(User user);
	public List<Income> search(User user,int categoryID,int accountID);
	public void remove(User user,int id);
}
