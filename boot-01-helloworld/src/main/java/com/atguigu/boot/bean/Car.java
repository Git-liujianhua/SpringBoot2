package com.atguigu.boot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有再容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;
    private String price;


}
