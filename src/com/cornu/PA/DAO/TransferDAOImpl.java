package com.cornu.PA.DAO;

import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.catalina.manager.util.SessionUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cornu.PA.bean.Transfer;
import com.cornu.PA.user.bean.User;
import com.cornu.PA.util.hibernate.HibernateUtil;

public class TransferDAOImpl implements TransferDAO{

	@Override
	public void save(Transfer transfer) {
		Session session=HibernateUtil.openSession();//打开Session 获取连接
		Transaction tx=session.beginTransaction();//开启事务
		try {
			session.save(transfer); //保存信息
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
	public List<Transfer> getAll(User user) {
		Session session=HibernateUtil.openSession();
		Transaction tx=session.beginTransaction();
		List<Transfer> transferList=null;
		try {
			Query query=session.createQuery("from Transfer where UserID="+user.getId()+" order by CreateTime desc");
			transferList=query.list();
			tx.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();//出错回滚事务
		}finally{
			HibernateUtil.closeSession(session); //关闭连接
		}
		return transferList;
	}

}
