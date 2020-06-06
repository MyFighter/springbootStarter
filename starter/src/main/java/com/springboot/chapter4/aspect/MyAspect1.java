package com.springboot.chapter4.aspect;

import com.springboot.chapter3.pojo.User;
import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.aspect.validator.impl.UserValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;

@Aspect
public class MyAspect1 implements Ordered {
    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {}

    @Before("manyAspects()")
    public void before(){
        System.out.println("aspect1 before.....");
    }

    @After("manyAspects()")
    public void after(){
        System.out.println("aspect1 after......");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("aspect1 afterReturning...");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
