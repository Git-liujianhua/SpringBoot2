package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/xiuluo.jpg")
    public String hello(){
        return "aaaa";
    }

    // @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET----张三";
    }

    // @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST----张三";
    }

    // @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT----张三";
    }

    // @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE----张三";
    }

    /**
     * 扩展点：如何把_methodz这个名字换成我们自己喜欢的
     */
}
