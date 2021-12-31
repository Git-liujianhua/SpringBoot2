package com.atguigu.admin.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {
//    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        //默认每次访问当前的uri就会计数+1
        stringStringValueOperations.increment(uri);
        return true;
    }
}
