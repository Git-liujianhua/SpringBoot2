package com.atguigu.admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * 自定义的端点无需在去配置文件做开启，默认开启状态
 * 整个EndPoint是参与整个线上运维的监控功能的
 */
@Component
@Endpoint(id = "myServer")
public class MyServer {

    /**
     * 既然是一个get方法那就相当于这个方法和属性一样，所以这个方法一定不能有传参
     *
     * @return
     */
    @ReadOperation
    public Map getDockerInfo(){
        //端点的读操作
        return Collections.singletonMap("dockerInfo","docker started...");
    }

    @WriteOperation
    public void writeDockerInfo(){
        System.out.println("docker restarted....");
    }
}
