package com.springboot.starter;

import com.springboot.chapter3.bean.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private ConfigBean configBean;

    @RequestMapping("/")
    String index(){
        return configBean.getName() + "..." + configBean.getTitle() + "\r\n" + configBean.getWholeTitle();
    }

}
