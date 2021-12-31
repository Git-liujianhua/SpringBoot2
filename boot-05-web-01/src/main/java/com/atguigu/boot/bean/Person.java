package com.atguigu.boot.bean;

/**
 * form action="/saveuser" method="post">
 *     姓名：<input name="username" value="zhangsan"><br>
 *     年龄：<input name="age" value="22"><br>
 *     生日：<input name="birth" value="2021/09/16"><br>
 *     宠物姓名：<input name="pet.name" value="cat"><br>
 *     宠物年龄：<input name="pet.age" value="5"><br>
 *     <input type="submit" value="提交">
 * </form>
 */

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
