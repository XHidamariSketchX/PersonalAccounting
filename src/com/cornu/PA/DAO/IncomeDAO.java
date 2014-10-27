package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.Income;
import com.cornu.PA.bean.Payment;
import com.cornu.PA.user.bean.User;

public interface IncomeDAO {
public void save(Income income);
public void update(Income income);
public Income getOneByID(int id);
public List<Income> getAll(User user);
public List<Income> searchByCategoryAccount(User user,int categoryID, int accountID);
public void delete(Income income);
}
