package com.springboot.chapter3.bean;

import com.springboot.chapter3.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@ComponentScan
//@ComponentScan(basePackageClasses =  {User.class})
@ComponentScan(basePackages =  {"com.springboot.chapter3.*"}, lazyInit = false)
//,excludeFilters = {@ComponentScan.Filter(classes = {Service.class})}
@ImportResource (value = "classpath:spring-other.xml")
public class AppConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/chapter3");
        props.setProperty("username", "root");
        props.setProperty("password", "123456");
        BasicDataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

//    @Bean(name = "dataSource")
//    @Conditional(DatabaseConditional.class)
//    public DataSource getDataSource(
//            @Value("${database.driverName}") String driver,
//            @Value("${database.url}") String url,
//            @Value("${database.username}") String username,
//            @Value("${database.password}") String password){
//        Properties props = new Properties();
//        props.setProperty("driver", driver);
//        props.setProperty("url", url);
//        props.setProperty("username", username);
//        props.setProperty("password", password);
//        BasicDataSource dataSource = null;
//        try {
//            dataSource = BasicDataSourceFactory.createDataSource(props);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }

}
