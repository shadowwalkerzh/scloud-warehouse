### scloud-streaming-flink


### scloud-config-server
spring cloud config server project


### scloud-eureka
spring cloud eureka server project


### scloud-feign-client


### scloud-graceful-shutdown
 > spring boot 1.5.xx + jetty graceful shutdown
 > Change org.apache.catalina.core.StandardContext unloadDelay = 80000

#### Testing
1. execute a long time cost request: `curl http://localhost:9006/jetty/shutdown/sleep/60000`.
2. execute shutdown request: `curl -vvv -X POST http://localhost:19006/shutdown`.
3. execute a new normal request: `curl http://localhost:9006/jetty/shutdown/ping` if you have only one server, will return failed with message `Failed to connect to localhost port 9006: Connection refused`, otherwise the request will be routed to other biz servers registered in eureka.

#### Success Console:
```
>>>>>>>>>>>>>>>>>sleep starting>>>>>>>>>>>>>>
>>>>>>>>>>>>>>>>>sleep finished>>>>>>>>>>>>>>
Stopped JettyEmbeddedWebAppContext
```


### scloud-graceful-shutdown
Change org.apache.catalina.core.StandardContext unloadDelay = 80000

#### Testing
1. `curl http://localhost:9004/shutdown/tomcat/sleep/60000`
2. `curl -XPOST http://localhost:19004/shutdown`
3. `curl curl http://localhost:9004/tomcat/shutdown/ping`,if you have only one server, will return failed with message `Recv failure: Connection reset by peer`, otherwise the request will be routed to other biz servers registered in eureka.

#### Success Console:
```>>>>>>>>>>>>>>>>>sleep starting>>>>>>>>>>>>>>
Stopping service [Tomcat]
>>>>>>>>>>>>>>>>>sleep finished>>>>>>>>>>>>>>
```


### scloud-graceful-shutdown
Change org.apache.catalina.core.StandardContext unloadDelay = 80000

#### Testing
1. `curl http://localhost:9005/shutdown/undertow/sleep/60000`
2. `curl -XPOST http://localhost:19005/shutdown`
3. `curl curl http://localhost:9005/undertow/shutdown/ping`,if you have only one server, will return null.

#### Success Console:
```>>>>>>>>>>>>>>>>>sleep starting>>>>>>>>>>>>>>
>>>>>>>>>>>>>>>>>sleep finished>>>>>>>>>>>>>>
Destroying Spring FrameworkServlet 'dispatcherServlet'
```


### scloud-hystrix


### scloud-micro-service-1


### scloud-micro-service-2


### scloud-sleuth


### scloud-zuul








