package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.bean.HistoryPurchase;
import com.cornu.PA.user.bean.User;

public interface HistoryPurchaseBis {
	public void add(HistoryPurchase historyPurchase);
	public void modify(HistoryPurchase historyPurchase);
	public List<HistoryPurchase> getAll(User user);
	public HistoryPurchase getOnebyID(User user,int id);
	public void remove(HistoryPurchase historyPurchase);
}
