package com.cornu.PA.user.business;


import com.cornu.PA.DAO.AccountDAO;
import com.cornu.PA.DAO.AccountDAOImpl;
import com.cornu.PA.DAO.BalanceDAO;
import com.cornu.PA.DAO.BalanceDAOImpl;
import com.cornu.PA.DAO.IncomeCategoryDAO;
import com.cornu.PA.DAO.IncomeCategoryDAOImpl;
import com.cornu.PA.DAO.PaymentCategoryDAO;
import com.cornu.PA.DAO.PaymentCategoryDAOImpl;

import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.Balance;
import com.cornu.PA.bean.IncomeCategory;
import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.user.DAO.UserDAO;
import com.cornu.PA.user.DAO.UserDAOImpl;
import com.cornu.PA.user.bean.User;

public class UserBisImpl implements UserBis{

	@Override
	public int regist(User user) {
		UserDAO userDAO=new UserDAOImpl();
		User registedUser=userDAO.getOneUserByUsername(user.getUsername());
		if(registedUser!=null){
			return User.REGIST_HAS;
		}
		if(registedUser==null){
			try{
				userDAO.save(user);
				
				
				AccountDAO accountDAO=new AccountDAOImpl();
				Account account=new Account();
				account.setAccountName("现金");
				account.setBalance(new Float(0));
				account.setUser(user);
				accountDAO.save(account);
				
				PaymentCategory pc=new PaymentCategory();
				pc.setPaymentCategoryName("其他");
				pc.setUser(user);
				PaymentCategoryDAO pcDAO=new PaymentCategoryDAOImpl();
				pcDAO.save(pc);
				
				IncomeCategory ic=new IncomeCategory();
				ic.setIncomeCategoryName("其他");
				ic.setUser(user);
				IncomeCategoryDAO icDAO=new IncomeCategoryDAOImpl();
				icDAO.save(ic);
				
				BalanceDAO balanceDAO=new BalanceDAOImpl();
				Balance balance=new Balance();
				balance.setTotalIncome(0);
				balance.setTotalPayment(0);
				balance.setUser(user);
				balanceDAO.setInit(balance);
				
				return User.REGIST_SUCCESS;
			}catch(Exception e){e.printStackTrace();}
		}
		return User.REGIST_FAILED;
	}
	@Override
	public User login(User user) {
		UserDAO userDAO=new UserDAOImpl();
		User registedUser=userDAO.getOneUserByUsername(user.getUsername());//获取要登录用户的信息
		if(registedUser==null) //判断是已注册用户
			return null;
		if(user.getUsername().trim().equals(registedUser.getUsername().trim())
				&&user.getPassword().trim().equals(registedUser.getPassword().trim())){//判断用户名密码是否一致
			return registedUser;
		}
		return null;
	}
	@Override
	public void modifyPassword(User user) {
		UserDAO userDAO=new UserDAOImpl();
		userDAO.update(user);
	}

}
