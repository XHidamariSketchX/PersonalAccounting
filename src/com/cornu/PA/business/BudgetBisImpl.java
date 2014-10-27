package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.DAO.BudgetDAO;
import com.cornu.PA.DAO.BudgetDAOImpl;
import com.cornu.PA.bean.Budget;
import com.cornu.PA.user.bean.User;

public class BudgetBisImpl implements BudgetBis {

	@Override
	public void add(Budget budget) {
		BudgetDAO budgetDAO=new BudgetDAOImpl();
		budgetDAO.save(budget);
	}

	@Override
	public void modify(Budget budget) {
		BudgetDAO budgetDAO=new BudgetDAOImpl();
		budgetDAO.update(budget);
	}

	@Override
	public Budget getOneByID(int id) {
		BudgetDAO budgetDAO=new BudgetDAOImpl();
		return budgetDAO.getOneByID(id);
	}

	@Override
	public List<Budget> getALl(User user) {
		BudgetDAO budgetDAO=new BudgetDAOImpl();
		return budgetDAO.getAll(user);
	}

	@Override
	public void achieve(Budget budget) {
		budget.setState(Budget.ACHIEVED);
		BudgetDAO budgetDAO=new BudgetDAOImpl();
		budgetDAO.update(budget);

	}

	@Override
	public void remove(Budget budget) {
		BudgetDAO budgetDAO=new BudgetDAOImpl();
		budgetDAO.remove(budget);
		
	}

}
