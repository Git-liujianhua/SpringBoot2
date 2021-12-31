package com.atguigu.admin;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdmin02ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

//    @Autowired
    StringRedisTemplate stringRedisTemplate;
//    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Test
    void contextLoads() {
//        jdbcTemplate.queryForObject("select count(*) from HrmResource");
//        jdbcTemplate.queryForList("select count(*) from HrmResource");
        Long aLong = jdbcTemplate.queryForObject("select count(*) from city", Long.class);

        log.info("记录总数为：{}",aLong);

        log.info("数据源类型 {}",dataSource.getClass());

    }

    @Autowired
    UserMapper userMapper;
    @Test
    void userMapperTest(){
        User user = userMapper.selectById(2L);
        log.info("用户信息{}",user);
    }

//    @Transactional
    @Test
    void redis(){
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("hello888","world888");
        String hello888 = stringStringValueOperations.get("hello888");
        System.out.println(hello888);
        System.out.println(redisConnectionFactory.getClass());
    }

}
