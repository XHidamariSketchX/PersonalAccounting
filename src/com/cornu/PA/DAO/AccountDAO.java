package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.Account;
import com.cornu.PA.user.bean.User;

public interface AccountDAO {
public void save(Account account);
public void update(Account account);
public Account getOneByID(int id);
public List<Account> getAll(User user);
public List<Account> getAllInvestmentAccount(User user);
}
