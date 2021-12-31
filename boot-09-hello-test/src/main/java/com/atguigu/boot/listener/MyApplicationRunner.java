package com.atguigu.boot.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner和ApplicationRunner的两个实现类可以使用@Order注解排序控制谁先运行，数字越大，谁就先运行
 * 应用启动做一个一次性事情就可以实现CommandLineRunner或ApplicationRunner接口去做
 */
@Order(1)
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner......run.......");
    }
}
