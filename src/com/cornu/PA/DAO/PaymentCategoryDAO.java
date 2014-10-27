package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.user.bean.User;

public interface PaymentCategoryDAO {
	public void save(PaymentCategory paymentCategory);
	public void update(PaymentCategory paymentCategory);
	public PaymentCategory getOneByID(int id);
	public List<PaymentCategory> getAll(User user);
}
