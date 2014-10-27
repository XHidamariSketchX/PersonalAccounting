package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.Budget;
import com.cornu.PA.user.bean.User;

public interface BudgetDAO {
public void save(Budget budget);
public void update(Budget budget);
public List<Budget> getAll(User user);
public Budget getOneByID(int id);
public void remove(Budget budget);
}
