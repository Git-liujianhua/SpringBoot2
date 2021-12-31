package com.atguigu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.atguigu.admin.mapper")
@ServletComponentScan(basePackages = "com.atguigu.admin.servlet")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class Boot05WebAdmin02Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot05WebAdmin02Application.class, args);
    }

}
