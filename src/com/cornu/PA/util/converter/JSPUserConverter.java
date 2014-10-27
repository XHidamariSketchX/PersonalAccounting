package com.cornu.PA.util.converter;

import java.util.Map;

import com.cornu.PA.user.bean.User;

import ognl.DefaultTypeConverter;

public class JSPUserConverter extends DefaultTypeConverter {
	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		System.out.println("converting.....");
		if(User.class==toType){// converter jsp page para to user bean
			
			String[] str=(String[])value;
			String username=str[0];
			String password=str[1];
			String email=str[2];
			User user=new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setUsername(username);
			
			return user;
		}
		return null;
		
	}

}
