package com.cornu.PA.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Account;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void save(Account account) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.save(account); 
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
	public Account getOneByID(int id) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		Account account=null;
		try {
			account=(Account)session.get(Account.class, id); //获取一个账户
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return account;
	}

	@Override
	public List<Account> getAll(User user) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		List<Account> accountList=null;
		try {
			Query query=session.createQuery("from Account where UserID="+user.getId());
			accountList=query.list();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return accountList;
	}

	@Override
	public void update(Account account) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.update(account);
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
	public List<Account> getAllInvestmentAccount(User user) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		List<Account> accountList=null;
		try {
			Query query=session.createQuery("from Account where UserID="+user.getId()+" and Type="+Account.INVESTMENT);
			accountList=query.list();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return accountList;
	}

}
