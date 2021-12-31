package com.atguigu.admin.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 注意类名必须要要有HealthIndicator作为后缀，主件名的是截取MyComponentHealthIndicator这个HealthIndicator剩下的MyComponent为主件名
 */
@Component
public class MyComponentHealthIndicator extends AbstractHealthIndicator {

    /**
     * 真实的检查方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //mongodb：获取连接进行测试
        Map<String,Object> map = new HashMap<String,Object>();
        //判断自己的业务逻辑返回状态
        //检查完成
        if (1 == 1){
//            builder.up();  //健康
            builder.status(Status.UP);
            map.put("count",2);
            map.put("ms","连接成功");
        }else {
//            builder.down();  //生病
            builder.status(Status.OUT_OF_SERVICE);
            map.put("count",1);
            map.put("ms","连接失败");
        }
        //返回详细数据
        builder.withDetail("code",100)
                .withDetail("err",map);
    }
}
