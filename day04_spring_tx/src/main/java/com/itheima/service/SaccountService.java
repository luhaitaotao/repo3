package com.itheima.service;

import com.itheima.domain.Saccount;

public interface SaccountService {
    Saccount findbyId(Integer id);
    void transfer(String sourceName,String targetName,double money);
}
