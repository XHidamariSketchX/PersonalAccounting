package com.cornu.PA.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Investment;
import com.cornu.PA.bean.InvestmentType;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;

public class InvestmentDAOImpl implements InvestmentDAO {

	@Override
	public void save(Investment investment) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		try {
			session.save(investment);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				//出错回滚事务
				tx.rollback();
			}
		}finally{
			//关闭连接
			HibernateUtil.closeSession(session); 
		}
		
	}

	@Override
	public void update(Investment investment) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		try {
			session.update(investment);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				//出错回滚事务
				tx.rollback();
			}
		}finally{
			//关闭连接
			HibernateUtil.closeSession(session); 
		}
		
	}

	@Override
	public Investment getOneByID(int id) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		Investment investment=null;
		try {
			investment=(Investment) session.get(Investment.class, id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				//出错回滚事务
				tx.rollback();
			}
		}finally{
			//关闭连接
			HibernateUtil.closeSession(session); 
		}
		return investment;
	}

	@Override
	public List<Investment> getAll(User user) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		List<Investment> investmentList=null;
		try {
			Query query=session.createQuery("from Investment where UserID="+user.getId()+" order by CreateTime desc" );
			investmentList=query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				//出错回滚事务
				tx.rollback();
			}
		}finally{
			//关闭连接
			HibernateUtil.closeSession(session); 
		}
		return investmentList;
	}

	@Override
	public void delete(Investment investment) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		try {
			session.delete(investment);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				//出错回滚事务
				tx.rollback();
			}
		}finally{
			//关闭连接
			HibernateUtil.closeSession(session); 
			}
	}
}
