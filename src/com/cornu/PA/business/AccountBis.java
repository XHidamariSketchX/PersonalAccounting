package com.cornu.PA.business;

import java.math.BigDecimal;
import java.util.List;

import com.cornu.PA.bean.Account;
import com.cornu.PA.user.bean.User;

public interface AccountBis {
public Account getOneByID(int id);
public void add(Account account);
public void modify(Account account);
public void amountAdd(Account account,Float amount);
public void amountAddByID(int accountID,Float amount);
public void amountSub(Account account,Float amount);
public void amountSubByID(int accountID,Float amount);
public List<Account> getAll(User user);
public List<Account> getAllInvestmentAccount(User user);
}
