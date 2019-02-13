package com.wan.scloud.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuowan on 2019/1/16 15:27.
 * Description:
 */

@Slf4j
@RestController
@EnableEurekaClient
@SpringBootApplication
public class SCloudServiceApplication {

    @Value("${spring.project.name:default project name}")
    private String projectName;

    public static void main(String[] args) {
        SpringApplication.run(SCloudServiceApplication.class, args);
    }

    @GetMapping(value = "ping")
    public String service1Ping() {
        log.info(">>>>>>>>>>>>>>>>>>Called service1/ping>>>>>>>>>>>>>>>>>>>");
        return projectName;
    }

    @GetMapping(value = "retry")
    public String service1Retry() throws RuntimeException {
        throw new RuntimeException("Exception and retry...................");

        // comment last row and uncommented below blocks on another server port
        // log.info(">>>>>>>>>>>>>>>>>>Called service1/ping>>>>>>>>>>>>>>>>>>>");
        // return projectName;
    }

}
