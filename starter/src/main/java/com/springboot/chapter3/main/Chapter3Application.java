package com.springboot.chapter3.main;

import com.springboot.chapter3.bean.AppConfig;
import com.springboot.chapter3.scope.pojo.ScopeBean;
import com.springboot.other.pojo.Squirrel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.springboot.chapter3"})
//@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class Chapter3Application {

    public static void main(String[] args) {
//        SpringApplication.run(Chapter3Application.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ScopeBean bean1 = ctx.getBean(ScopeBean.class);
        ScopeBean bean2 = ctx.getBean(ScopeBean.class);
        System.out.println(bean1 == bean2);

        Squirrel squirrel = ctx.getBean("squirrel", Squirrel.class);
        squirrel.use();

        bean1.time();
    }
}
