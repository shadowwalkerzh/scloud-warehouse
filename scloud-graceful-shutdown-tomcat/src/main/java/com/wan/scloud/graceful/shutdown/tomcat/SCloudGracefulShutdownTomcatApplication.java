package com.wan.scloud.graceful.shutdown.tomcat;

import org.apache.catalina.core.StandardContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by zhuowan on 2019/1/16 15:27.
 * Description:
 */

@EnableEurekaClient
@SpringBootApplication
public class SCloudGracefulShutdownTomcatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCloudGracefulShutdownTomcatApplication.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.addContextCustomizers(context -> {
            if (context instanceof StandardContext) {
                ((StandardContext) context).setUnloadDelay(80000);
            }
        });
        return factory;
    }

}
