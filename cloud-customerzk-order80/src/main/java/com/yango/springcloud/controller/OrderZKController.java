package com.yango.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/1/31 0031 21:40
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderZKController {

    public static final String INVOKE_URL="http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/zk")
    public String paymentInfo () {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return "consumer调用provider=======" +  result;
    }
}
