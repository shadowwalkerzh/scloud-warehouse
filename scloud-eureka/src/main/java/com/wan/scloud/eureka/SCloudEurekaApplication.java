package com.wan.scloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zhuowan on 2019/1/16 15:19.
 * Description:
 */

@EnableEurekaServer
@SpringBootApplication
public class SCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCloudEurekaApplication.class, args);
    }

}
