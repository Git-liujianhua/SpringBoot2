package com.atguigu.admin.controller;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CityService cityService;

//    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("/city")
    public City queryCityById(@RequestParam("id")Integer id){
        return cityService.queryCity(id);
    }

    @ResponseBody
    @PostMapping("/citys")
    public City saveCity(City city1){
        cityService.insertCity(city1);
        System.out.println(city1);
        return city1;
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from city", Long.class);
        return aLong.toString();
    }

    /**
     * 跳转登录（login）页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession httpSession, Model model){

        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassWord())){
            httpSession.setAttribute("loginUser",user);
            //登录成功重定向到main.html  重定向防止表单提交
            return "redirect:/main.io";
        }else {
            model.addAttribute("msg","用户名密码错误，请检查后重新登录！");
            return "login";
        }
    }

    /**
     * 跳转main页面
     * @return
     */
    @GetMapping("/main.io")
    public String mainPage(HttpSession httpSession,Model model){
        log.info("当前方法是{}","mainPage");
//        if (httpSession.getAttribute("loginUser") != null){
//            return "main";
//        }else {
//            model.addAttribute("msg","请重新登录！");
//            return "login";
//        }
//        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
//        String main = stringStringValueOperations.get("/main.io");
//        String sql = stringStringValueOperations.get("/sql");
//        model.addAttribute("main",main);
//        model.addAttribute("sql",sql);
        return "main";

    }
}
