package com.springboot.chapter3.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mrbird.blog")
@Data
public class ConfigBean {

    private String name;

    private String title;

    private String wholeTitle;
}
