package com.springboot.chapter3.scope.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
public class ScopeBean {

    //spring EL
    @Value("#{T(System).currentTimeMillis()}")
    public Long initTime = null;

    public void time(){
        System.out.println(initTime);
    }
}
