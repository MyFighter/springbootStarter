package com.springboot.chapter4.main;

import com.springboot.chapter3.bean.ConfigBean;
import com.springboot.chapter4.intercept.MyInterceptor;
import com.springboot.chapter4.proxy.ProxyBean;
import com.springboot.chapter4.service.HelloService;
import com.springboot.chapter4.service.impl.HelloServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({ConfigBean.class})
@SpringBootApplication
public class StarterApplication {

	public static void main(String[] args) {
		testProxy();
	}

	private static void testProxy() {
		HelloService helloService = new HelloServiceImpl();
		//模拟代理
		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
		proxy.setHello("zhangsan");
	}

}
