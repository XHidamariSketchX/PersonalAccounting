package com.cornu.PA.user.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Account;
import com.cornu.PA.bean.Payment;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;


public class UserDAOImpl implements UserDAO {

	@Override
	public void save(User user) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.save(user); //保存用户信息
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
	public User getOneUserByUsername(String username) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		User user=null;  //初始为空，不存在用户名为username的用户就返回null
		try {
			Query query=session.createQuery("from User where UserName='"+username+"'");//查找用户名为username的用户
			List<User> users=(List<User>)query.list();//获取列表
			if(users!=null&&users.size()==1){ //存在且只有一个用户 
				user=users.get(0); //从列表获取唯一用户信息
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}finally{
			HibernateUtil.closeSession(session);
		}
		return user;
	}
	@Override
	public void update(User user) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.update(user); //更新用户信息
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
