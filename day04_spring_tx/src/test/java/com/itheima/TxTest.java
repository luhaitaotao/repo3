package com.itheima;

import com.itheima.domain.Saccount;
import com.itheima.service.SaccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        SaccountService saccountService = ac.getBean("saccountService", SaccountService.class);
        Saccount saccount = saccountService.findbyId(1);
        System.out.println(saccount);


    }
}
