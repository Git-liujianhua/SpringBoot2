package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理Bean的方法
 *      全模式：Full(proxyBeanMethods = true)
 *      轻量级模式：Lite(proxyBeanMethods = false)
 *      组件依赖
 * SpringBoot最大的更新：配置类可以编写轻量级模式proxyBeanMethods = false和全模式proxyBeanMethods = true
 * 调整成false的有点：SpringBoot不会检查配置类中的方法返回值会不会在容器中，就会跳过检查，整个SpringBoot启动运行就会更快一些
 * 最佳实战：
 *          如果只是在容器中单单注册一个组件与别的组件也不会产生依赖使用：轻量级模式：Lite(proxyBeanMethods = false)，试SpringBoot启动运行加载变快
 *          如果组件会与其他组件产生依赖就使用：全模式：Full(proxyBeanMethods = true)，保证组件所依赖的组件就是容器中的组件
 *
 * 4、@Import({User.class, DBHelper.class})
 *          给容器中自动创建出两个类型的组件、默认组件的名字就是全类名
 *
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)  //告诉SpringBoot这是一个配置类 == 配置文件
// @ConditionalOnBean(name = "TomPet")
@ConditionalOnMissingBean(name = "TomPet")
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)
//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
public class MyConfig {

    /**
     * w外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */

    @Bean   //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回值，就是组件在容器中的实例
    public User MyUser(){
        User zhangsan = new User("zhangsan", "18");
        //user组件依赖pet组件
        zhangsan.setPet(MyPet());
        return zhangsan;
    }

    @Bean("TomPet1")
    public Pet MyPet(){
        return new Pet("tomcat");
    }
}
