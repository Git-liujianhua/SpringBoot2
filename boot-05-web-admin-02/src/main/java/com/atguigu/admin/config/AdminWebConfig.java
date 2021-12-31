package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.LoginInterceptor;
import com.atguigu.admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有，则静态资源也会被拦截，需要单独排除放行，如果是精确拦截则就不需要关注静态资源的拦截了】
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     * Filter、Interceptor  几乎拥有相同的功能？
     * 1、Filter是Servlet定义的原生组件。好处：脱离了Spring应用也能使用
     * 2、Interceptor是Spring定义的接口，所以只有Spring应用才能使用，可以使用Spring的自动装配等功能
     */
//    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")     //所有请求都被拦截包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sql/**","/citys/**");     //放行的请求
//        registry.addInterceptor(redisUrlCountInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/citys/**");
    }

    /**
     * 太过于底层的定制化，如果没有完全掌握SpringBoot的底层逻辑慎用
     * @return
     */
//    @Bean
//    public WebMvcRegistrations webMvcRegistrations(){
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return WebMvcRegistrations.super.getRequestMappingHandlerMapping();
//            }
//        };
//    }
}
