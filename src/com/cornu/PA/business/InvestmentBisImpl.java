package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.DAO.InvestmentDAO;
import com.cornu.PA.DAO.InvestmentDAOImpl;
import com.cornu.PA.bean.Investment;
import com.cornu.PA.user.bean.User;

public class InvestmentBisImpl implements InvestmentBis {

	@Override
	public void add(Investment investment) {
		InvestmentDAO investmentDAO=new InvestmentDAOImpl();
		investmentDAO.save(investment);

	}

	@Override
	public void modify(Investment investment) {
		InvestmentDAO investmentDAO=new InvestmentDAOImpl();
		investmentDAO.update(investment);

	}

	@Override
	public Investment getOneByID(int id) {
		InvestmentDAO investmentDAO=new InvestmentDAOImpl();
		return investmentDAO.getOneByID(id);
	}

	@Override
	public List<Investment> getALl(User user) {
		InvestmentDAO investmentDAO=new InvestmentDAOImpl();
		return investmentDAO.getAll(user);
	}

	@Override
	public void payback(Investment investment) {
		//设置完成标志
		investment.setState(Investment.FINISH);
		InvestmentDAO investmentDAO=new InvestmentDAOImpl();
		investmentDAO.update(investment);

	}

	@Override
	public void remove(User user, int id) {
		InvestmentDAO investmentDAO=new InvestmentDAOImpl();
		
		investmentDAO.delete(investmentDAO.getOneByID(id));
	}

}
