package com.wan.scloud.service2;

import com.wan.scloud.service.bean.ResponseBean;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.http.HttpStatus;
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

    // same path but diff service id
    @GetMapping(value = "service/route-by-path-multi-service-id")
    public ResponseBean routeByPath() {
        return ResponseBean.success("biz/service/route-by-path route to service2 success ......");
    }

    // unique path
    @GetMapping(value = "service2/route-by-path-unique-service-id")
    public ResponseBean routeByService2Path() {
        return ResponseBean.success("biz/service2/route-by-path-unique-service-id routing success ......");
    }

    // override to diff app final path
    @GetMapping(value = "/service2/override/route-by-final-dpath")
    public ResponseBean routeByOverride() {
        return ResponseBean.success("/service2/override/route-by-final-dpath routed success ......");
    }

    // retry
    @GetMapping(value = "/service2/retry")
    public ResponseBean routeByRetry(HttpServletResponse rep) {
        int retryCount = new Random().nextInt(100);
        log.info("biz/service2/retry from service2 with param retryCount: {}", retryCount);
        if (retryCount % 2 == 0) {
            rep.setStatus(HttpStatus.SC_RESET_CONTENT);
            return ResponseBean.error();
        }

        return ResponseBean.success("biz/service2/retry response from service2 success ......");
    }

}
