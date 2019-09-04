package com.wan.scloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.io.InputStream;
import java.nio.charset.Charset;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

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
        RequestContext rcx = RequestContext.getCurrentContext();
        rcx.setSendZuulResponse(false);
        String responseString = null;
        try {
            InputStream is = rcx.getResponseDataStream();
            if (is != null) {
                responseString = StreamUtils.copyToString(is, Charset.forName("UTF-8"));
            }
            log.info("HandleResponseFilter response data stream to string: {}", responseString);
            responseString = StringUtils.isEmpty(responseString) ? rcx.getResponseBody() : responseString;
            log.info("ResponseHandlingFilter -> run finished with response string: {}", responseString);
            rcx.setResponseBody(responseString);
        } catch (Exception e) {
            log.warn("HandleResponseFilter parse response error: ", e);
        }
        return null;
    }

}
