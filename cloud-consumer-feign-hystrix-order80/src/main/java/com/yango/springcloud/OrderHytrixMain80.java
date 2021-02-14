package com.yango.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/13 0013 22:39
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class OrderHytrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHytrixMain80.class, args);
    }
}
