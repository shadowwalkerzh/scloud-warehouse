package com.wan.scloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by zhuowan on 2019/1/11 17:27.
 * Description:
 */

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class SCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCloudConfigServerApplication.class, args);
    }

}
