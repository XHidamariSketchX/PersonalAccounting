package com.cornu.PA.util.interceptor;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cornu.PA.bean.Balance;
import com.cornu.PA.business.BalanceBis;
import com.cornu.PA.business.BalanceBisImpl;
import com.cornu.PA.user.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session=invocation.getInvocationContext().getSession();
		User user=(User)session.get("loginuser");
		if(user==null){
			return "need_login";
		}
		else{
			
			BalanceBis balanceBis=new BalanceBisImpl();
			Balance balance=balanceBis.getBalance(user);
			session.put("balance", balance);
			 return invocation.invoke();
		}
		
	}

}
