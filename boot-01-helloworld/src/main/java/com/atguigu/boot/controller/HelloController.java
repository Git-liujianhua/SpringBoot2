package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @ResponseBody
// @Controller
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car Car(){
        return car;
    }

    @RequestMapping("/hello2")
    public String handle01(@RequestParam("name")String name){
        log.info("请求进来了");
        return "Hello, Spring Boot 2 !!!"+"你好"+name;
    }
}
