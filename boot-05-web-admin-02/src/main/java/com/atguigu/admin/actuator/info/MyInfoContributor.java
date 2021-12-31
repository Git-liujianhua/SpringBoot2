package com.atguigu.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class MyInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("code",100)
                .withDetail("hello","world")
                .withDetail("AppMap", Collections.singletonMap("XYG","仙友Game"))
                .withDetails(Collections.singletonMap("java","SpringBoot"));
    }
}
