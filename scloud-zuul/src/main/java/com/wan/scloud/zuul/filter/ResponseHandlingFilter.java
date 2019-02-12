package com.wan.scloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Created by zhuowan on 2019/2/11 16:55.
 * Description:
 */

@Slf4j
public class ResponseHandlingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
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
        log.info("ResponseHandlingFilter -> run finished......");
        return null;
    }
}
