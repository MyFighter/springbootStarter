package com.springboot.chapter4.aspect;

import com.springboot.chapter3.pojo.User;
import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.aspect.validator.impl.UserValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {
    @DeclareParents(value = "com.springboot.chapter4.aspect.service.impl.UserServiceImpl+",
            defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {}

    @Before("pointCut() && args(user)")
    public void beforeParam(JoinPoint point, User user){
        Object[] args = point.getArgs();
        System.out.println("before param .......");
    }

    @Before("pointCut()")
    public void before(){
        System.out.println("before.....");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("after......");
    }

//    @Around("pointCut()")
//    public void around(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("around before......");
//        jp.proceed();
//        Object[] args = jp.getArgs();
//        System.out.println("around after......");
//    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }
}
