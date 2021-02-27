package com.yango.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/21 0021 21:11
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderNacosController {
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);

    }

}
