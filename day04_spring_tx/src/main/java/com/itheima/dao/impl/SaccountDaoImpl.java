package com.itheima.dao.impl;

import com.itheima.dao.SaccountDao;
import com.itheima.domain.Saccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("saccountDao")
public class SaccountDaoImpl implements SaccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Saccount findById(Integer id) {
        Saccount saccount = jdbcTemplate.queryForObject("select * from saccount where id=?",
                new BeanPropertyRowMapper<Saccount>(Saccount.class), id);
        return saccount;
    }

    public Saccount findByName(String name) {
        List<Saccount> saccounts = jdbcTemplate.query("select * from saccount where name=?",
                new BeanPropertyRowMapper<Saccount>(Saccount.class),name);
        if (saccounts.size()==0 ||saccounts==null){
            return null;
        }
        if (saccounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return saccounts.get(0);
    }

    public void updateSaccount(Saccount saccount) {
        jdbcTemplate.update("update saccount set name=?,money=?,where id=?",saccount.getName(),
                saccount.getMoney(),saccount.getId());

    }
}
