package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User implements Serializable {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String passWord;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
