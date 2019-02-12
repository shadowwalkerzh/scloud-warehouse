package com.wan.scloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created by zhuowan on 2019/2/11 16:43.
 * Description:
 */

@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
@EnableRetry
@SpringBootApplication
public class SCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCloudZuulApplication.class, args);
    }

}
