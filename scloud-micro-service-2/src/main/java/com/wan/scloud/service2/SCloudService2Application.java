package com.wan.scloud.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuowan on 2019/1/16 15:27.
 * Description:
 */

@RestController
@EnableEurekaClient
@SpringBootApplication
public class SCloudService2Application {

    public static void main(String[] args) {
        SpringApplication.run(SCloudService2Application.class, args);
    }

    @GetMapping(value = "ping")
    public String service1Ping() {
        return "PONG";
    }

}
