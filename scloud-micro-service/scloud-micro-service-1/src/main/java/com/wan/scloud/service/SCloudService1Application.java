package com.wan.scloud.service;

import com.wan.scloud.service.bean.ResponseBean;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.ZuulServerAutoConfiguration;
import org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter;
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
public class SCloudService1Application {

    public static void main(String[] args) {
        SpringApplication.run(SCloudService1Application.class, args);
    }

    /**
     * Zuul auto configuration class: {@link ZuulServerAutoConfiguration}
     *
     * sets various proxy related headers for downstream requests. {@link PreDecorationFilter}
     *
     * different micro module with same routing path strategy
     * {@link org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator#getZuulRoute}
     */

    // same path but diff service id
    @GetMapping(value = "biz/service/route-by-path-multi-service-id")
    public ResponseBean routeByPath() {
        return ResponseBean.success("biz/service/route-by-path route to service1 success >>>>>>>>>>>>>>>>>>>>>>");
    }

    // unique path
    @GetMapping(value = "biz/service1/route-by-path-unique-service-id")
    public ResponseBean routeByService1Path() {
        return ResponseBean.success("biz/service1/route-by-path-unique-service-id routing success >>>>>>>>>>>>>>>>>>>>>>");
    }

    // override from current app path
    @GetMapping(value = "biz/service1/override/route-by-cpath")
    public ResponseBean routeByOverrideCpath() {
        return ResponseBean.success("/service1/override/route-by-cpath routed success >>>>>>>>>>>>>>>>>>>>>>");
    }

    // override from diff app path
    @GetMapping(value = "biz/service1/override/route-by-dpath")
    public ResponseBean routeByOverrideDpath() {
        return ResponseBean.success("/service1/override/route-by-dpath routed success >>>>>>>>>>>>>>>>>>>>>>");
    }

    // override to current app final path
    @GetMapping(value = "biz/service1/override/route-by-final-cpath")
    public ResponseBean routeByOverrideFinalPath() {
        return ResponseBean.success("/service1/override/route-by-final-cpath routed success >>>>>>>>>>>>>>>>>>>>>>");
    }

}
