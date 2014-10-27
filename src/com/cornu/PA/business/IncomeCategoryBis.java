package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.bean.IncomeCategory;
import com.cornu.PA.user.bean.User;

public interface IncomeCategoryBis {
public void add(IncomeCategory incomeCategory);
public void modify(IncomeCategory incomeCategory);
public IncomeCategory getOneByID(int id);
public List<IncomeCategory> getAll(User user);
}
