package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类：也叫做：主配置类
 * @SpringBootApplication:这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        //1、返回我们的IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2、查看IOC容器里面的组件
        String[] names = run.getBeanDefinitionNames();

        for (String name:names) {
            System.out.println(name);
        }

        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanNamesForType = run.getBeanNamesForType(CacheAutoConfiguration.class);
        System.out.println("==========="+beanNamesForType.length);

        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("==========="+beanNamesForType1.length);
        // //从容器中获取组件，注册来的组件默认就是单实例的
        // User myUser = run.getBean("MyUser", User.class);
        //
        // User myUser01 = run.getBean("MyUser", User.class);
        //
        // System.out.println("组件: " + myUser.equals(myUser01));
        //
        // //4、com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$4424ed54@143d9a93
        // MyConfig bean = run.getBean(MyConfig.class);
        // System.out.println(bean);
        // //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有
        // //保持组件单实例
        // Pet pet = bean.MyPet();
        // Pet pet2 = bean.MyPet();
        // System.out.println(pet.equals(pet2));
        //
        // User myUser1 = run.getBean("MyUser", User.class);
        // Pet tomPet = run.getBean("TomPet", Pet.class);
        // System.out.println("用户的宠物："+myUser1.getPet().equals(tomPet));
        //
        //
        // String[] beanNamesForType = run.getBeanNamesForType(User.class);
        // for (String name: beanNamesForType) {
        //     System.out.println(name);
        // }
        // String[] beanNamesForType1 = run.getBeanNamesForType(DBHelper.class);
        // for (String name: beanNamesForType1) {
        //     System.out.println(name);
        // }

        boolean tomPet = run.containsBean("TomPet");
        System.out.println("容器中的TomPet组件：" + tomPet);

        boolean myUser = run.containsBean("MyUser");
        System.out.println("容器中的MyUser组件：" + myUser);

        boolean tomPet1 = run.containsBean("TomPet1");
        System.out.println("容器中的TomPet1组件：" + tomPet1);

        boolean haha = run.containsBean("haha");
        System.out.println("haha: " + haha);//true

        boolean hehe = run.containsBean("hehe");
        System.out.println("hehe: " + hehe);//true
    }
}
