package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.DAO.IncomeCategoryDAO;
import com.cornu.PA.DAO.IncomeCategoryDAOImpl;
import com.cornu.PA.bean.IncomeCategory;
import com.cornu.PA.user.bean.User;

public class IncomeCategoryBisImpl implements IncomeCategoryBis {

	@Override
	public void add(IncomeCategory incomeCategory) {
		IncomeCategoryDAO icDAO=new IncomeCategoryDAOImpl();
		icDAO.save(incomeCategory);

	}
	@Override
	public List<IncomeCategory> getAll(User user) {
		IncomeCategoryDAO icDAO=new IncomeCategoryDAOImpl();
		return icDAO.getAll(user);
	}
	@Override
	public IncomeCategory getOneByID(int id) {
		IncomeCategoryDAO icDAO=new IncomeCategoryDAOImpl();		
		return icDAO.getOneByID(id);
	}
	@Override
	public void modify(IncomeCategory incomeCategory) {
		IncomeCategoryDAO icDAO=new IncomeCategoryDAOImpl();		
		icDAO.update(incomeCategory);
	}
}
