package com.yango.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yango.springcloud.service.PaymentHytrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/13 0013 22:43
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "payment_global_fallback_method")//定义全局异常/超时处理方法
public class OrderHytrixController {
    @Resource
    private PaymentHytrixService paymentHytrixService;

    @GetMapping("/payment/hytrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHytrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/payment/hytrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //int age = 1/0;
        String result = paymentHytrixService.paymentInfo_TimeOut(id);
        return result;
    }

    /**
     * paymentInfo_TimeOut方法报错或者超时时的回调方法
     */
    public String paymentInfo_TimeOutHandler (@PathVariable("id") Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "id:" + id + ",消费者80繁忙，稍后重试";
    }

    /**
     * 全局的超时或者报错的回调方法
     */
    public String payment_global_fallback_method() {
        return "线程池：" + Thread.currentThread().getName() + " 全局异常处理，请稍后重试";
    }

}
