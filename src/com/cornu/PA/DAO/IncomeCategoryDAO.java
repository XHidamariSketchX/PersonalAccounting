package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.IncomeCategory;
import com.cornu.PA.user.bean.User;


public interface IncomeCategoryDAO {
	public void save(IncomeCategory incomeCategory);
	public void update(IncomeCategory incomeCategory);
	public IncomeCategory getOneByID(int id);
	public List<IncomeCategory> getAll(User user);
}
