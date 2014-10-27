package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.user.bean.User;

public interface PaymentCategoryBis {
public void add(PaymentCategory paymentCategory);
public void modify(PaymentCategory paymentCategory);
public PaymentCategory getOneByID(int id);
public List<PaymentCategory> getAll(User user);
}
