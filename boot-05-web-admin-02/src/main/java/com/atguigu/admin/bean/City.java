package com.atguigu.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class City {

    private Integer id;

    private String name;

    private String countryCode;

    private String district;

    private Integer population;
}
