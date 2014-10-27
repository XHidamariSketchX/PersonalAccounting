package com.cornu.PA.business;

import java.math.BigDecimal;
import java.util.List;

import com.cornu.PA.DAO.TransferDAO;
import com.cornu.PA.DAO.TransferDAOImpl;
import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.Transfer;
import com.cornu.PA.user.bean.User;

public class TransferBisImpl implements TransferBis {

	@Override
	public void add(Transfer transfer) {
		TransferDAO transferDAO=new TransferDAOImpl();
		try {
		//从转出账户扣除金额
		//加到转入账户	
			//创建账户业务层
			AccountBis accountBis=new AccountBisImpl();
			//扣除转账金额
			accountBis.amountSubByID(transfer.getOutAccount().getId(), transfer.getAmount());
			//增加转账金额
			accountBis.amountAddByID(transfer.getInAccount().getId(), transfer.getAmount());
			
			//保存transfer
			transferDAO.save(transfer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Transfer> getAll(User user) {
		TransferDAO transferDAO=new TransferDAOImpl();
		return transferDAO.getAll(user);
	}

}
