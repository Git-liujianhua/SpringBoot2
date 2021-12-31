package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/success")
    public String success(Model model){

        //model中的数据会被放在请求域中 request.setAttribute()中
        model.addAttribute("msg","Hello Thymeleaf");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
