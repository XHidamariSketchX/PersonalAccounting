package com.cornu.PA.DAO;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Payment;
import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;
import com.sun.org.apache.bcel.internal.generic.AALOAD;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void save(Payment payment) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.save(payment); 
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
	public Payment getOneByID(int id) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		Payment payment=null;
		try {
			payment=(Payment)session.get(Payment.class, id); //获取一个记录
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return payment;
	}

	@Override
	public List<Payment> getAll(User user) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		List<Payment> paymentList=null;
		try {
			Query query=session.createQuery("from Payment where UserID="+user.getId()+" order by CreateTime desc");
			paymentList=query.list();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		
		return paymentList;
	}

	@Override
	public void update(Payment payment) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.update(payment); 
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
	public void delete(Payment payment) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.delete(payment); 
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
	public List<Payment> searchByCategoryAccount(User user,int categoryID, int accountID) {
		StringBuffer where=new StringBuffer();
		where.append("where UserID=");
		where.append(user.getId());
		if(categoryID!=0){
			where.append(" and PaymentCategoryID=");
			where.append(categoryID);
		}
		if(accountID!=0){
			where.append(" and AccountID=");
			where.append(accountID);
		}
		where.append("order by CreateTime desc");
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		List<Payment> paymentList=null;
		try {
			Query query=session.createQuery("from Payment "+where);
			paymentList=query.list();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return paymentList;
	}


}
