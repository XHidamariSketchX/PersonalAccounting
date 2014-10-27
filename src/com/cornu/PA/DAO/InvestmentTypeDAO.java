package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.InvestmentType;
import com.cornu.PA.user.bean.User;

public interface InvestmentTypeDAO {
	public void save(InvestmentType investmentType);
	public void update(InvestmentType investmentType);
	public InvestmentType getOneByID(int id);
	public List<InvestmentType> getAll(User user);
}
