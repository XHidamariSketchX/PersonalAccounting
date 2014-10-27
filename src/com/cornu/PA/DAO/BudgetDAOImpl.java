package com.cornu.PA.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Budget;
import com.cornu.PA.bean.Income;
import com.cornu.PA.bean.Investment;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;

public class BudgetDAOImpl implements BudgetDAO {

	@Override
	public void save(Budget budget) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.save(budget); 
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
	public void update(Budget budget) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.update(budget); 
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
	public List<Budget> getAll(User user) {
		//打开Session 获取连接
		Session session=HibernateUtil.openSession();
		//开启事务
		Transaction tx=session.beginTransaction();
		List<Budget> BudgetList=null;
		try {
			Query query=session.createQuery("from Budget where UserID="+user.getId()+" order by CreateTime desc" );
			BudgetList=query.list();
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
		return BudgetList;

	}

	@Override
	public Budget getOneByID(int id) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		Budget budget=null;
		try {
			budget=(Budget)session.get(Budget.class, id); //获取一个记录
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return budget;
	}

	@Override
	public void remove(Budget budget) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.delete(budget); 
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
