package com.springboot.starter;

import com.springboot.chapter3.bean.AppConfig;
import com.springboot.chapter3.definition.Person;
import com.springboot.chapter3.pojo.BussinessPerson;
import com.springboot.chapter3.pojo.User;
import com.springboot.chapter3.scope.pojo.ScopeBean;
import com.springboot.chapter3.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest {
    private static Logger log = Logger.getLogger(IocTest.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.close();
//        BussinessPerson person = ctx.getBean(BussinessPerson.class);
//        person.service();
    }
}
