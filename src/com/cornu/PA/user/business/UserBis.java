package com.cornu.PA.user.business;

import com.cornu.PA.user.bean.User;

public interface UserBis {
public int regist(User user);
public User login(User user);
public void modifyPassword(User user);
}
