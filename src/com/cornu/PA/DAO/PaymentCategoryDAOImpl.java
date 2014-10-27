package com.cornu.PA.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Income;
import com.cornu.PA.bean.PaymentCategory;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;

public class PaymentCategoryDAOImpl implements PaymentCategoryDAO {

	@Override
	public void save(PaymentCategory paymentCategory) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			
			session.save(paymentCategory); 
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
	public PaymentCategory getOneByID(int id) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		PaymentCategory paymentCategory=null;
		try {
			paymentCategory=(PaymentCategory)session.get(PaymentCategory.class, id); //获取一个记录
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return paymentCategory;
	}

	@Override
	public List<PaymentCategory> getAll(User user) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		List<PaymentCategory> pcList=null;
		try {
			Query query=session.createQuery("from PaymentCategory where UserID="+user.getId());
			pcList=query.list();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return pcList;
	}

	@Override
	public void update(PaymentCategory paymentCategory) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.update(paymentCategory); 
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
