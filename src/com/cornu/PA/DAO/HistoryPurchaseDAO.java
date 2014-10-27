package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.HistoryPurchase;
import com.cornu.PA.user.bean.User;

public interface HistoryPurchaseDAO {
	public void save(HistoryPurchase historyPurchase);
	public void update(HistoryPurchase historyPurchase);
	public List<HistoryPurchase> getAll(User user);
	public HistoryPurchase getOneByID(int id);
	public void delete(HistoryPurchase historyPurchase);
}
