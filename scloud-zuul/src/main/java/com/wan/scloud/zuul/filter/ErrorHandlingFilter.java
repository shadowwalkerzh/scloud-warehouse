package com.wan.scloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Created by zhuowan on 2019/2/11 16:55.
 * Description:
 */

@Slf4j
public class ErrorHandlingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
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
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(HttpServletResponse.SC_OK);
        Throwable throwable = (Throwable) ctx.remove("throwable"); // use this line ,it will work fine
        if (throwable instanceof ZuulException) {
            ctx.setResponseBody("Handled Error Result");
        }

        log.info("ErrorHandlingFilter -> run finished......");
        return null;
    }
}

