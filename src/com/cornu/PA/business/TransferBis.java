package com.cornu.PA.business;

import java.util.List;

import com.cornu.PA.bean.Transfer;
import com.cornu.PA.user.bean.User;

public interface TransferBis {
public void add(Transfer transfer);
public List<Transfer> getAll(User user);
}
