package com.yango.springcloud;

import com.yango.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/1/17 0017 21:54
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
