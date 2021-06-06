package com.itheima.service.impl;

import com.itheima.dao.SaccountDao;
import com.itheima.domain.Saccount;
import com.itheima.service.SaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("saccountService")
@Transactional
public class SacciuntServiceImpl implements SaccountService {
    @Autowired
    private SaccountDao saccountDao;

   /* public void setSaccountDao(SaccountDao saccountDao) {
        this.saccountDao = saccountDao;
    }
*/
    public Saccount findbyId(Integer id) {
        return saccountDao.findById(id);
    }

    public void transfer(String sourceName, String targetName, double money) {
        Saccount source = saccountDao.findByName(sourceName);
        Saccount targe = saccountDao.findByName(targetName);
        source.setMoney(source.getMoney()-money);
        targe.setMoney(targe.getMoney()+money);
        saccountDao.updateSaccount(source);
        saccountDao.updateSaccount(targe);

    }
}
