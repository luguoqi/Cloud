package com.yango.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/15 0015 14:12
 * @Version 1.0
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置了一个id为path_route_yango的路由规则，当访问http://localhost:9527/guonei 时会自动转发到地址http://news.baidu.com/guonei
     */
    @Bean
    public RouteLocator contomRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        RouteLocator routeYango = routes.route("path_route_yango", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routeYango;


    }
}
