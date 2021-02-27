package com.yango.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/18 0018 22:29
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos register, serverport=" + serverPort + "\t id:" + id;
    }

}
