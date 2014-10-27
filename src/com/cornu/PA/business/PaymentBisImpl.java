package com.cornu.PA.business;

import java.math.BigDecimal;
import java.util.List;

import com.cornu.PA.DAO.AccountDAO;
import com.cornu.PA.DAO.AccountDAOImpl;
import com.cornu.PA.DAO.PaymentDAO;
import com.cornu.PA.DAO.PaymentDAOImpl;
import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.Payment;
import com.cornu.PA.user.bean.User;

public class PaymentBisImpl implements PaymentBis {

	@Override
	public void add(Payment payment) {
		try {
			//创建账户业务层
			AccountBis accountBis=new AccountBisImpl();
			//修改账户余额
			accountBis.amountSubByID(payment.getAccount().getId(), payment.getAmount());
			//保存payment
			PaymentDAO paymentDAO=new PaymentDAOImpl();
			paymentDAO.save(payment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public Payment getOneByID(int id) {
		PaymentDAO paymentDAO=new PaymentDAOImpl();
		return paymentDAO.getOneByID(id);
	}

	@Override
	public List<Payment> getAll(User user) {
		PaymentDAO paymentDAO=new PaymentDAOImpl();
		
		return paymentDAO.getAll(user);
	}

	@Override
	public void modify(Payment payment) {
		PaymentDAO paymentDAO=new PaymentDAOImpl();
		paymentDAO.update(payment);
		
	}

	@Override
	public void modify(Float oldAmount, Payment payment) {
		//计算变化值  正数支付金额减少 负数支付金额增加
		Float changAmount=new Float(oldAmount.floatValue()-payment.getAmount().floatValue());
		AccountBis accountBis=new AccountBisImpl();
		//不取反  修改账户余额
		accountBis.amountAddByID(payment.getAccount().getId(), changAmount);
		//修改
		this.modify(payment);
	}

	@Override
	public void modify(int oldAccountID, Float oldAmount, Payment payment) {
		AccountBis accountBis=new AccountBisImpl();
		//恢复原账户余额
		accountBis.amountAddByID(oldAccountID, oldAmount);
		//修改现账户余额
		accountBis.amountSubByID(payment.getAccount().getId(), payment.getAmount());
		//修改
		this.modify(payment);
	}

	@Override
	public void remove(User user, int id) {
		PaymentDAO paymentDAO=new PaymentDAOImpl();
		paymentDAO.delete(paymentDAO.getOneByID(id));
	}

	@Override
	public List<Payment> search(User user, int categoryID, int accountID) {
		PaymentDAO paymentDAO=new PaymentDAOImpl();
		return paymentDAO.searchByCategoryAccount(user, categoryID, accountID);
	}
	

}
