package com.wan.scloud.zuul.config;

import com.wan.scloud.zuul.filter.ErrorHandlingFilter;
import com.wan.scloud.zuul.filter.PreAuthFilter;
import com.wan.scloud.zuul.filter.ResponseHandlingFilter;
import com.wan.scloud.zuul.filter.RoutingFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuowan on 2019/2/11 16:56.
 * Description:
 */

@Configuration
public class ZuulConfiguration {

    // Filter registration
    @Bean("PreAuthFilter")
    public PreAuthFilter preAuthFilter() {
        return new PreAuthFilter();
    }

    @Bean("RoutingFilter")
    public RoutingFilter routingFilter() {
        return new RoutingFilter();
    }

    @Bean("ResponseHandlingFilter")
    public ResponseHandlingFilter responseHandlingFilter() {
        return new ResponseHandlingFilter();
    }

    @Bean("ErrorHandlingFilter")
    public ErrorHandlingFilter errorHandlingFilter() {
        return new ErrorHandlingFilter();
    }


}
