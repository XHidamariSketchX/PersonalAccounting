package com.cornu.PA.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Balance;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;

public class BalanceDAOImpl implements BalanceDAO {

	@Override
	public void setInit(Balance balance) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.save(balance); 
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}

	}

	@Override
	public Balance getBalance(User user) {
		this.cacl_balance(user);
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		List<Balance> balanceList;
		Balance balance;
		try {
			Query query=session.createQuery("from Balance where UserID="+user.getId());
			balanceList=query.list();
			balance=balanceList.get(0);
			tx.commit();//提交事务
			return balance;
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		
		return null;
	}
	private void cacl_balance(User user){
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			SQLQuery sqlQuery = session.createSQLQuery("{call cacl_balance(?)}");
	    	sqlQuery.setInteger(0, user.getId());
	    	sqlQuery.executeUpdate();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
	}


}
