package com.atguigu.admin.service;

import com.atguigu.admin.bean.City;

public interface CityService {

    public City queryCity(Integer id);

    public void insertCity(City city);
}
