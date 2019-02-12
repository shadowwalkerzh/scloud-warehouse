package com.wan.scloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Created by zhuowan on 2019/2/11 16:55.
 * Description: PRE type zuul filter
 */

@Slf4j
public class PreAuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("PreAuthFilter -> run finished......");
        return null;
    }
}
