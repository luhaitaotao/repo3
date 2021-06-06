package com.itheima.dao;

import com.itheima.domain.Saccount;

public interface SaccountDao {
    Saccount findById(Integer id);
    Saccount findByName(String name);
    void updateSaccount(Saccount saccount);
}
