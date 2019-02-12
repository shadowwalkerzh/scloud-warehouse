package com.wan.scloud.graceful.shutdown.jetty;

import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhuowan on 2019/1/16 15:27.
 * Description:
 */

@EnableEurekaClient
@SpringBootApplication
public class SCloudGracefulShutdownJettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCloudGracefulShutdownJettyApplication.class, args);
    }

    /**
     * ContextHandler.Context context=ContextHandler.getCurrentContext();
     * _servletContext=context==null?new ContextHandler.StaticContext():context;
     * _contextHandler=(ServletContextHandler)(context==null?null:context.getContextHandler());
     */
    @Bean
    public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory() {
        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
        factory.addServerCustomizers((JettyServerCustomizer) server -> {
            server.setStopAtShutdown(false);
            server.setStopTimeout(80000);
            /*
             * StatisticsHandler has to be added for graceful shutdown to work (see
             * https://github.com/eclipse/jetty.project/issues/1549#issuecomment-301102535)
             */
            StatisticsHandler statisticsHandler = new StatisticsHandler();
            statisticsHandler.setHandler(server.getHandler());
            server.setHandler(statisticsHandler);
        });
        return factory;
    }

}
