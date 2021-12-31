package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.City;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    public City getCity(Integer id);

    @Insert("insert into city(`name`,`countryCode`,`district`,`population`) values (#{name},#{countryCode},#{district},#{population})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);

}
