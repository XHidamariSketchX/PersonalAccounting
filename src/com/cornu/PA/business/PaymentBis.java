package com.cornu.PA.business;

import java.math.BigDecimal;
import java.util.List;

import com.cornu.PA.bean.Payment;
import com.cornu.PA.user.bean.User;

public interface PaymentBis {
	public void add(Payment payment);
	public Payment getOneByID(int id);
	public List<Payment> getAll(User user);
	public List<Payment> search(User user,int categoryID,int accountID);
	public void modify(Payment payment);
	public void modify(Float oldAmount,Payment payment);
	public void modify(int oldAccountID,Float oldAmount,Payment payment);
	public void remove(User user,int id);
}
