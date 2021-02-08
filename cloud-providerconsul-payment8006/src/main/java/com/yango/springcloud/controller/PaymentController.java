package com.yango.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/1 0001 22:28
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String SERVER_PORT;
    @GetMapping("/payment/consul")
    public String paymentzk() {
        return "springcloud with consul :" + SERVER_PORT + "\t" + UUID.randomUUID().toString();
    }

}
