package com.cornu.PA.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Income;
import com.cornu.PA.bean.IncomeCategory;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;

public class IncomeDAOImpl implements IncomeDAO{

	@Override
	public void save(Income income) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.save(income); 
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
	public Income getOneByID(int id) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		Income income=null;
		try {
			income=(Income)session.get(Income.class, id); //获取一个记录
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return income;
	}

	@Override
	public List<Income> getAll(User user) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		List<Income> incomeList=null;
		try {
			Query query=session.createQuery("from Income where UserID="+user.getId()+" order by CreateTime desc");
			incomeList=query.list();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return incomeList;
	}

	@Override
	public void update(Income income) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.update(income); 
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
	public void delete(Income income) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.delete(income);
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
	public List<Income> searchByCategoryAccount(User user, int categoryID,
			int accountID) {
		StringBuffer where=new StringBuffer();
		where.append("where UserID=");
		where.append(user.getId());
		if(categoryID!=0){
			where.append(" and IncomeCategoryID=");
			where.append(categoryID);
		}
		if(accountID!=0){
			where.append(" and AccountID=");
			where.append(accountID);
		}
		where.append("order by CreateTime desc");
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		List<Income> incomeList=null;
		try {
			Query query=session.createQuery("from Income "+where);
			incomeList=query.list();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();//出错回滚事务
			}
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return incomeList;
	}

}
