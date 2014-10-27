package com.cornu.PA.business;

import com.cornu.PA.DAO.BalanceDAO;
import com.cornu.PA.DAO.BalanceDAOImpl;
import com.cornu.PA.bean.Balance;
import com.cornu.PA.user.bean.User;

public class BalanceBisImpl implements BalanceBis {

	@Override
	public Balance getBalance(User user) {
		BalanceDAO balanceDAO=new BalanceDAOImpl();
		return balanceDAO.getBalance(user);
	}

}
