package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.DAO.IncomeDAO;
import com.cornu.PA.DAO.IncomeDAOImpl;
import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.Income;
import com.cornu.PA.user.bean.User;

public class IncomeBisImpl implements IncomeBis {

	@Override
	public void add(Income income) {
		try {			
			//创建账户业务层
			AccountBis accountBis=new AccountBisImpl();
			accountBis.amountAddByID(income.getAccount().getId(), income.getAmount());
			//保存income
			IncomeDAO incomeDAO=new IncomeDAOImpl();
			incomeDAO.save(income);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Income> getAll(User user) {
		IncomeDAO incomeDAO=new IncomeDAOImpl();
		return incomeDAO.getAll(user);
	}
	@Override
	public Income getOneByID(int id) {
		IncomeDAO incomeDAO=new IncomeDAOImpl();
		return incomeDAO.getOneByID(id);
	}
	@Override
	public void modify(Income income) {
		IncomeDAO incomeDAO=new IncomeDAOImpl();
		incomeDAO.update(income);
	}
	@Override
	public void modify(Float oldAmount, Income income) {
		//计算变化值  负数收入增加 正数收入减少
		Float changAmount=new Float(oldAmount.floatValue()-income.getAmount().floatValue());
		AccountBis accountBis=new AccountBisImpl();
		
		//变化值取反 修改账户余额
		accountBis.amountAddByID(income.getAccount().getId(), 0-changAmount.floatValue());
		//修改
		this.modify(income);
		
	}
	@Override
	public void modify(int oldAccountID, Float oldAmount, Income income) {
		AccountBis accountBis=new AccountBisImpl();
		//恢复原账户余额
		accountBis.amountSubByID(oldAccountID, oldAmount);
		//修改现账户余额
		accountBis.amountAddByID(income.getAccount().getId(), income.getAmount());
		//修改
		this.modify(income);
		
	}
	@Override
	public void remove(User user, int id) {
		IncomeDAO incomeDAO=new IncomeDAOImpl();
		incomeDAO.delete(incomeDAO.getOneByID(id));
	}
	@Override
	public List<Income> search(User user, int categoryID, int accountID) {
		IncomeDAO incomeDAO=new IncomeDAOImpl();
		return incomeDAO.searchByCategoryAccount(user, categoryID, accountID);
	}
}
