package com.cornu.PA.DAO;

import com.cornu.PA.bean.Balance;
import com.cornu.PA.user.bean.User;

public interface BalanceDAO {
	public void setInit(Balance balance);
	public Balance getBalance(User user);
}
