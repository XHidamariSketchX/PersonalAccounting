package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.Investment;
import com.cornu.PA.user.bean.User;

public interface InvestmentDAO {
	public void save(Investment investment);
	public void update(Investment investment);
	public Investment getOneByID(int id);
	public List<Investment> getAll(User user);
	public void delete(Investment investment);
}
