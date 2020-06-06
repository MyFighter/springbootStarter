package com.springboot.chapter3.pojo;

import com.springboot.chapter3.definition.Animal;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫【"+Dog.class.getSimpleName()+"】是用来玩的");
    }
}
