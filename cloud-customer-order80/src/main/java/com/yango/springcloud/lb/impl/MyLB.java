package com.yango.springcloud.lb.impl;

import com.yango.springcloud.lb.ILoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/7 0007 22:54
 * @Version 1.0
 */
@Component
public class MyLB implements ILoadBalancer {


    private AtomicInteger nextServerCyclicCounter;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获取访问次数
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("======第几次访问 next=======" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        //获取第几次访问与服务集群刷量的取模，得到实际调用服务的下标
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
