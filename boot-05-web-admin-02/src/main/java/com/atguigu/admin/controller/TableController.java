package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    /**
     *
     * @RequestParam("a") int a a  不带请求参数或者参数类型不对  400： Bad Request（错误的请求） 一般都是浏览器的参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(){

//        int i = 10/0;
        return "tables/basic_table";
    }

    /**
     * 删除
     * @param id
     * @param pn
     * @param ra
     * @return
     */
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id")Long id,
                         @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                         RedirectAttributes ra){
//        RedirectAttributes   重定向携带参数的接口
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    /**
     * 分页查询
     * @param pn
     * @param model
     * @return
     */
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){

//        List<User> users = Arrays.asList(new User("刘建华", "123456"),
//                new User("张大仙", "12345dd"),
//                new User("刘德华", "12345dd"),
//                new User("lucy", "12345dd"),
//                new User("make", "12345dd"));
//        model.addAttribute("users",users);
//
//        if (users.size() >500){
//            throw new UserTooManyException();
//        }
        //从数据库中查出user表中的用户进行展示
        List<User> users = userService.list();
//        model.addAttribute("users",users);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("users",page);
        page.getPages();
        page.getCurrent();
        page.getTotal();
        page.getRecords();

        return "tables/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "tables/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "tables/editable_table";
    }
}
