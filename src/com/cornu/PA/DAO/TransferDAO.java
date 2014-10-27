package com.cornu.PA.DAO;

import java.util.List;

import com.cornu.PA.bean.Transfer;
import com.cornu.PA.user.bean.User;

public interface TransferDAO {
public void save(Transfer transfer);
public List<Transfer> getAll(User user);
}
