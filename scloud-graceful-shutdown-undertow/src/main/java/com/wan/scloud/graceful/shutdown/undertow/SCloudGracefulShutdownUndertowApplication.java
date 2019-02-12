package com.wan.scloud.graceful.shutdown.undertow;

import com.wan.scloud.graceful.shutdown.undertow.component.GracefulShutdownWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

/**
 * Created by zhuowan on 2019/1/16 15:27.
 * Description:
 */

@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class SCloudGracefulShutdownUndertowApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCloudGracefulShutdownUndertowApplication.class, args);
    }

    @Autowired
    private GracefulShutdownWrapper gracefulShutdownWrapper;

    @SneakyThrows
    @EventListener(ContextClosedEvent.class)
    public void contextClosedEvent() {
        log.info("contextClosedEvent graceful shutdown.....................................");
        gracefulShutdownWrapper.getGracefulShutdownHandler().shutdown();
        gracefulShutdownWrapper.getGracefulShutdownHandler().awaitShutdown(70000);
    }

}
