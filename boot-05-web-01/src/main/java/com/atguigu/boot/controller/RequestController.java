package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功了。。。。。");
        request.setAttribute("code",200);
        return "forward:/success.io";  //转发到 /success请求
    }

    @GetMapping("params")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){

        map.put("hello","world888");
        model.addAttribute("world","hello888");
        request.setAttribute("message","HelloWorld");
        Cookie cookie = new Cookie("n1","v1");
        response.addCookie(cookie);
        return "forward:/success.io";  //转发到 /success请求
    }

    @ResponseBody
    @GetMapping("/success.io")
    public Map<String,Object> success(@RequestAttribute(value = "msg",required = false) String msg,
                                      @RequestAttribute(value = "code",required = false) Integer code,
                                      HttpServletRequest request,
                                      HttpServletResponse response){
        Object msg1 = request.getAttribute("msg");
        Object code1 = request.getAttribute("code");

        Map<String,Object> map = new HashMap<>();
        map.put("annotation_msg",msg);
        map.put("annotation_code",code);
        map.put("reqMethod_msg1",msg1);
        map.put("reqMethod_code1",code1);


        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");
        map.put("hello",hello);
        map.put("world",world);
        map.put("message",message);
        return map;
    }


}
