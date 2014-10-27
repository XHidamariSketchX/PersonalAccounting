package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.DAO.InvestmentTypeDAO;
import com.cornu.PA.DAO.InvestmentTypeDAOImpl;
import com.cornu.PA.bean.InvestmentType;
import com.cornu.PA.user.bean.User;

public class InvestmentTypeBisImpl implements InvestmentTypeBis {

	@Override
	public void add(InvestmentType investmentType) {
		InvestmentTypeDAO itDAO=new InvestmentTypeDAOImpl();
		itDAO.save(investmentType);
	}

	@Override
	public void modify(InvestmentType investmentType) {
		InvestmentTypeDAO itDAO=new InvestmentTypeDAOImpl();
		itDAO.update(investmentType);

	}

	@Override
	public InvestmentType getOneByID(int id) {
		InvestmentTypeDAO itDAO=new InvestmentTypeDAOImpl();
		return itDAO.getOneByID(id);
	}

	@Override
	public List<InvestmentType> getALl(User user) {
		InvestmentTypeDAO itDAO=new InvestmentTypeDAOImpl();
		return itDAO.getAll(user);
	}

}
