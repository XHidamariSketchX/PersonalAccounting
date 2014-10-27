package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.DAO.HistoryPurchaseDAO;
import com.cornu.PA.DAO.HistoryPurchaseDAOImpl;
import com.cornu.PA.bean.HistoryPurchase;
import com.cornu.PA.user.bean.User;

public class HistoryPurchaseBisImpl implements HistoryPurchaseBis {

	@Override
	public void add(HistoryPurchase historyPurchase) {
		HistoryPurchaseDAO hpDAO=new HistoryPurchaseDAOImpl();
		hpDAO.save(historyPurchase);

	}

	@Override
	public void modify(HistoryPurchase historyPurchase) {
		HistoryPurchaseDAO hpDAO=new HistoryPurchaseDAOImpl();
		hpDAO.update(historyPurchase);

	}

	@Override
	public List<HistoryPurchase> getAll(User user) {
		HistoryPurchaseDAO hpDAO=new HistoryPurchaseDAOImpl();
		return hpDAO.getAll(user);
	}

	@Override
	public HistoryPurchase getOnebyID(User user,int id) {
		HistoryPurchaseDAO hpDAO=new HistoryPurchaseDAOImpl();
		return hpDAO.getOneByID(id);
	}

	@Override
	public void remove(HistoryPurchase historyPurchase) {
		HistoryPurchaseDAO hpDAO=new HistoryPurchaseDAOImpl();
		hpDAO.delete(historyPurchase);
	}

}
