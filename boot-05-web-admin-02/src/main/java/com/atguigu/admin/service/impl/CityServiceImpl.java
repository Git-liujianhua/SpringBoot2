package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityMapper;
import com.atguigu.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;
    Counter counter;

    /**
     * 构造器注入的方式：有参构造器
     * 直接给容器中放一个MeterBinder然后builder一个方法，然后注册到指标中心里边register中
     * 拿到指标的注册中心MeterRegistry
     * @param meterRegistry
     */
    public CityServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityServiceImpl.queryCity.running.counter");
    }

    public City queryCity(Integer id){
        counter.increment();
        return cityMapper.getCity(id);
    }

    public void insertCity(City city){
        cityMapper.insert(city);
    }
}
