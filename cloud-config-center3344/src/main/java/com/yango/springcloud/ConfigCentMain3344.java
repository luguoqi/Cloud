package com.yango.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/15 0015 21:39
 * @Version 1.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCentMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCentMain3344.class, args);
    }
}
