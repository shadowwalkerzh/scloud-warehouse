package com.wan.scloud.graceful.shutdown.tomcat.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhuowan on 2019/1/16 16:20.
 * Description:
 */

@Slf4j
@RestController
@RequestMapping("shutdown")
public class ShutdownController {

    @GetMapping(value = "ping")
    public String ping() {
        log.info(">>>>>>>>>>>>>>>>>PONG>>>>>>>>>>>>>>");
        return "PONG";
    }

    @SneakyThrows
    @GetMapping(value = "sleep/{milliSeconds}")
    public String sleepInSeconds(@PathVariable("milliSeconds") long milliSeconds) {
        log.info(">>>>>>>>>>>>>>>>>sleep starting>>>>>>>>>>>>>>");
        Thread.sleep(milliSeconds);
        log.info(">>>>>>>>>>>>>>>>>sleep finished>>>>>>>>>>>>>>");

        return "SUCCESS";
    }

}
