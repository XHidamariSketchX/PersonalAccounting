package com.cornu.PA.user.DAO;

import com.cornu.PA.user.bean.User;

public interface UserDAO {
public void save(User user);
public User getOneUserByUsername(String username);
public void update(User user);
}
