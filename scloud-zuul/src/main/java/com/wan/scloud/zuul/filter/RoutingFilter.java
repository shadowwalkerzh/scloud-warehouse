package com.wan.scloud.zuul.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Created by zhuowan on 2019/2/11 16:55.
 * Description:
 */

@Slf4j
public class RoutingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
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
        RequestContext rcx = RequestContext.getCurrentContext();
        String uri = rcx.getRequest().getRequestURI();
        rcx.setSendZuulResponse(true);
        log.info("RoutingFilter -> run with uri: {}", uri);
        return null;
    }
}
