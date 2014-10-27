package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.Payment;
import com.cornu.PA.user.bean.User;

public interface PaymentDAO {
public void save(Payment payment);
public Payment getOneByID(int id);
public List<Payment> getAll(User user);
public List<Payment> searchByCategoryAccount(User user,int categoryID,int accountID);
public void update(Payment payment);
public void delete(Payment payment);

}
