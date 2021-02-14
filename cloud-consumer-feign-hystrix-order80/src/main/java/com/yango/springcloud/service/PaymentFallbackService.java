package com.yango.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/14 0014 13:58
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHytrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "############PaymentFallbackService-paymentInfo_OK fall back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "############PaymentFallbackService-paymentInfo_TimeOut fall back";
    }
}
