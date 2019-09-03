package com.wan.scloud.service2;

import com.wan.scloud.service.bean.ResponseBean;

import lombok.extern.slf4j.Slf4j;

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
public class SCloudService2Application {

    public static void main(String[] args) {
        SpringApplication.run(SCloudService2Application.class, args);
    }

    @GetMapping(value = "service/route-by-path")
    public ResponseBean routeByPath() {
        return ResponseBean.success("biz/service/route-by-path route to service2 success");
    }


    @GetMapping(value = "service2/route-by-path")
    public ResponseBean routeByService2Path() {
        return ResponseBean.success("biz/service2/route-by-path routing success");
    }

    @GetMapping(value = "retry")
    public String service1Retry() {
        return null;
    }

}
