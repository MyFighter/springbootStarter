package com.springboot.chapter4.service.impl;

import com.springboot.chapter4.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void setHello(String name) {
        if( name == null || name.trim().equals(""))
            throw new RuntimeException("parameter is null");
        System.out.println("hello " + name);
    }
}
