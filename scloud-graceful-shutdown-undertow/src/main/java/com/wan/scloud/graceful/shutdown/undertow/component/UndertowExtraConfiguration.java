package com.wan.scloud.graceful.shutdown.undertow.component;

import io.undertow.UndertowOptions;

import lombok.AllArgsConstructor;

import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UndertowExtraConfiguration {

    private final GracefulShutdownWrapper gracefulShutdownWrapper;

    @Bean
    public UndertowEmbeddedServletContainerFactory servletWebServerFactory() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.addDeploymentInfoCustomizers(deploymentInfo -> deploymentInfo.addOuterHandlerChainWrapper(gracefulShutdownWrapper));
        factory.addBuilderCustomizers(builder -> builder.setServerOption(UndertowOptions.ENABLE_STATISTICS, true));
        return factory;
    }

}
