package com.atguigu.boot.config;

import com.atguigu.hello.service.HelloService;
import org.springframework.context.annotation.Bean;

//@Configuration
public class MyConfig {

    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
