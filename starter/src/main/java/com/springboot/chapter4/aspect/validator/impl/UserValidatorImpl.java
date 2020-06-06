package com.springboot.chapter4.aspect.validator.impl;

import com.springboot.chapter3.pojo.User;
import com.springboot.chapter4.aspect.validator.UserValidator;

public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新接口：" + UserValidator.class.getSimpleName());
        return user != null && user.getId() !=null && user.getUserName() != null;
    }
}
