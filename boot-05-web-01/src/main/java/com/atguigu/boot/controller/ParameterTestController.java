package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    /**
     * 数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
     * @param person
     * @return
     */
    @PostMapping("/saveuser")
    public Person saveUser(Person person){
        return person;
    }

    // /car/1/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(HttpServletResponse response,
                                     @PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader("Referer") String referer,
                                     @RequestHeader("Host") String host,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> param
                                     //@CookieValue("_ga") String _ga,@CookieValue("_ga") Cookie ck
                                     ){

        Cookie cookie = new Cookie("_ga","0095821465487414");
        cookie.setMaxAge(60);
        response.addCookie(cookie);
        Map<String,Object> map = new HashMap<>();
        // map.put("id",id);
        // map.put("username",name);
        // map.put("pv",pv);
        // map.put("User-Agent",userAgent);
        // map.put("Referer",referer);
        // map.put("Host",host);
        // map.put("header",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("param",param);
        // map.put("_ga",_ga);
        // map.put("cookie",ck);
        // System.out.println("cookie"+ck);
        // System.out.println(ck.getName()+"=======>"+ck.getValue()+"====>"+ck.getPath());
        return map;
    }
    @PostMapping("/save")
    public Map<String,Object> postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        System.out.println(content);
        System.out.println(map);
        return map;
    }

    /**
     *
     * @param low
     * @param brand
     * @param path
     *     1、语法：请求路径：/cars/sell;low=34;brand=byd,audi,yd
     *     2、SpringBoot默认是禁用了矩阵变量的功能，
     *              手动开启：原理：对于路径的处理。UrlPathHelper进行解析。
     *              removeSemicolonContent（移除分号内容）支持矩阵变量的
     *     3、矩阵变量必须有(绑定)url路径变量才能被解析
     * @return
     */
    @GetMapping("cars/{path}")
    public Map<String,Object> carsSell(@MatrixVariable("low") Integer low,
                                       @MatrixVariable("brand") List<String> brand,
                                       @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);

        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String,Object> boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                                   @MatrixVariable(value = "age",pathVar = "empId") Integer empAge,
                                   @PathVariable("bossId")String bossId,
                                   @PathVariable("empId")String empId,
                                   @PathVariable Map<String,String> pv){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        map.put("bossId",bossId);
        map.put("empId",empId);
        map.put("pv",pv);
        return map;
    }
}
