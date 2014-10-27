package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.DAO.AccountDAO;
import com.cornu.PA.DAO.AccountDAOImpl;
import com.cornu.PA.bean.Account;
import com.cornu.PA.user.bean.User;

public class AccountBisImpl implements AccountBis {

	@Override
	public Account getOneByID(int id) {
		AccountDAO accountDAO=new AccountDAOImpl();
		return accountDAO.getOneByID(id);
	}

	@Override
	public void add(Account account) {
		AccountDAO accountDAO=new AccountDAOImpl();
		accountDAO.save(account);
	}

	@Override
	public List<Account> getAll(User user) {
		AccountDAO accountDAO=new AccountDAOImpl();
		return accountDAO.getAll(user);
	}

	@Override
	public void modify(Account account) {
		AccountDAO accountDAO=new AccountDAOImpl();
		accountDAO.update(account);
		
	}

	@Override
	public void amountAdd(Account account, Float amount) {
		//设置求和后的余额
		account.setBalance(account.getBalance().floatValue()+amount.floatValue());
		AccountDAO accountDAO=new AccountDAOImpl();
		//更新余额
		accountDAO.update(account);
	}

	@Override
	public void amountAddByID(int accountID, Float amount) {
		//通过ID获取Account实例
		Account account=this.getOneByID(accountID);
		//设置求和后的余额
		account.setBalance(account.getBalance().floatValue()+amount.floatValue());
		AccountDAO accountDAO=new AccountDAOImpl();
		//更新余额
		accountDAO.update(account);
	}

	@Override
	public void amountSub(Account account, Float amount) {
		//设置求差后的余额
		account.setBalance(account.getBalance().floatValue()-amount.floatValue());
		AccountDAO accountDAO=new AccountDAOImpl();
		//更新余额
		accountDAO.update(account);
		
	}

	@Override
	public void amountSubByID(int accountID, Float amount) {
		//通过ID获取Account实例
		Account account=this.getOneByID(accountID);
		//设置求差后的余额
		account.setBalance(account.getBalance().floatValue()-amount.floatValue());
		AccountDAO accountDAO=new AccountDAOImpl();
		//更新余额
		accountDAO.update(account);
		
	}

	@Override
	public List<Account> getAllInvestmentAccount(User user) {
		AccountDAO accountDAO=new AccountDAOImpl();
		return accountDAO.getAllInvestmentAccount(user);
	}

}
