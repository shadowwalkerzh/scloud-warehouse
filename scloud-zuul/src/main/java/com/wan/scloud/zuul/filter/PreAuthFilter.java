package com.wan.scloud.zuul.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.REQUEST_URI_KEY;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVICE_ID_KEY;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * Created by zhuowan on 2019/2/11 16:55.
 * Description: PRE type zuul filter
 */

@Slf4j
public class PreAuthFilter extends ZuulFilter {

    /**
     * route with override request uri by key {@link FilterConstants#REQUEST_URI_KEY}
     */
    private static final String OVERRIDE_FROM_CURRENT_APP_PATH = "/biz/service1/override/route-by-cpath";
    private static final String OVERRIDE_FROM_DIFF_APP_PATH = "/biz/service1/override/route-by-dpath";
    private static final String OVERRIDE_TO_CURRENT_APP_PATH = "/biz/service1/override/route-by-final-cpath";
    private static final String OVERRIDE_TO_DIFF_APP_PATH = "/biz/service2/override/route-by-final-dpath";

    /**
     * specify the route to service-1
     * route with specific serviceId by key {@link FilterConstants#SERVICE_ID_KEY}
     */

    private static final String ROUTE_BY_SERVICE_ID = "/biz/service/route-by-path-multi-service-id";
    private static final String CUSTOM_SERVICE1_ID = "scloud-micro-service-1";
    private static final String CUSTOM_SERVICE2_ID = "scloud-micro-service-2";

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER + 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext rcx = RequestContext.getCurrentContext();
        String uri = rcx.getRequest().getRequestURI();

        switch (uri) {
            case OVERRIDE_FROM_CURRENT_APP_PATH:
                rcx.set(REQUEST_URI_KEY, OVERRIDE_TO_CURRENT_APP_PATH);
                break;
            case OVERRIDE_FROM_DIFF_APP_PATH:
                rcx.set(REQUEST_URI_KEY, OVERRIDE_TO_DIFF_APP_PATH);
                rcx.set(SERVICE_ID_KEY, CUSTOM_SERVICE2_ID);
                rcx.setRouteHost(null); // ribbon filter condition
                break;
            case ROUTE_BY_SERVICE_ID:
                String param = rcx.getRequest().getParameter("service-id");
                if (StringUtils.isNotEmpty(param)) {
                    rcx.set(SERVICE_ID_KEY, CUSTOM_SERVICE1_ID);
                    rcx.setRouteHost(null);
                }
                break;
            default:
                break;
        }

        rcx.setSendZuulResponse(true);
        log.info("PreAuthFilter -> run finished......");
        return null;
    }
}
