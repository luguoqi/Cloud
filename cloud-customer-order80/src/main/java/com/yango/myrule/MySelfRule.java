package com.yango.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/7 0007 22:22
 * @Version 1.0
 */
@Configuration
public class MySelfRule {

    /**
     * 自定义随机负载
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }

}
