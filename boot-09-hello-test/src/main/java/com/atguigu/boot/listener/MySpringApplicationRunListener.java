package com.atguigu.boot.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 因为改接口存在又默认实现所有失陷后不一定需要实现接口中的方法
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

    private SpringApplication springApplication;

    public MySpringApplicationRunListener(SpringApplication springApplication,String[] args) {
        this.springApplication = springApplication;
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("MySpringApplicationRunListener.......starting.....");
    }

    /**
     * 已经是过期的方法了
     */
    @Override
    public void starting() {
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("MySpringApplicationRunListener.......environmentPrepared.....");
    }

    /**
     * 已经是过期的方法了
     */
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener.......contextPrepared.....");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener.......contextLoaded.....");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener.......started.....");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener.......running.....");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MySpringApplicationRunListener.......failed.....");
    }
}
