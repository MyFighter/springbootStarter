package com.springboot.chapter4.aspect.service.impl;

import com.springboot.chapter3.pojo.User;
import com.springboot.chapter4.aspect.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void printUser(User user) {
        if(user == null)
            throw new RuntimeException("user is null");
        System.out.println("\tid = " + user.getId());
        System.out.println("\tuserName = " + user.getUserName());
        System.out.println("\tnote = " + user.getNote());
    }

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面顺序");
    }
}
