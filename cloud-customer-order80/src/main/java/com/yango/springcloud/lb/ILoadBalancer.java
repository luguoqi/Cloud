package com.yango.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 定义服务集群实例接口
 */
public interface ILoadBalancer {

    ServiceInstance instance (List<ServiceInstance> serviceInstances);


}
