package com.cornu.PA.DAO;

import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Investment;
import com.cornu.PA.bean.InvestmentType;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;

public class InvestmentTypeDAOImpl implements InvestmentTypeDAO {

	@Override
	public void save(InvestmentType investmentType) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		try {
			session.save(investmentType);
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
	public void update(InvestmentType investmentType) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		try {
			session.update(investmentType);
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
	public InvestmentType getOneByID(int id) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		InvestmentType investmentType=null;
		try {
			investmentType=(InvestmentType) session.get(InvestmentType.class, id);
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
		return investmentType;
	}

	@Override
	public List<InvestmentType> getAll(User user) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		List<InvestmentType> itList=null;
		try {
			Query query=session.createQuery("from InvestmentType where UserID="+user.getId() );
			itList=query.list();
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
		return itList;
	}

}
