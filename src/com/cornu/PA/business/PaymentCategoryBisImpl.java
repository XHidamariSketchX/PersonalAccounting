package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.DAO.PaymentCategoryDAO;
import com.cornu.PA.DAO.PaymentCategoryDAOImpl;
import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.user.bean.User;

public class PaymentCategoryBisImpl implements PaymentCategoryBis {

	@Override
	public void add(PaymentCategory paymentCategory) {
		PaymentCategoryDAO pcDAO=new PaymentCategoryDAOImpl();
		pcDAO.save(paymentCategory);

	}

	@Override
	public List<PaymentCategory> getAll(User user) {
		PaymentCategoryDAO pcDAO=new PaymentCategoryDAOImpl();
		
		return pcDAO.getAll(user);
	}

	@Override
	public PaymentCategory getOneByID(int id) {
		PaymentCategoryDAO pcDAO=new PaymentCategoryDAOImpl();
		
		return pcDAO.getOneByID(id);
	}

	@Override
	public void modify(PaymentCategory paymentCategory) {
		PaymentCategoryDAO pcDAO=new PaymentCategoryDAOImpl();
		pcDAO.update(paymentCategory);
	}

}
