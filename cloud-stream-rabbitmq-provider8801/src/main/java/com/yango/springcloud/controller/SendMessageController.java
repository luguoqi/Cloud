package com.yango.springcloud.controller;

import com.yango.springcloud.service.IMssageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/17 0017 19:52
 * @Version 1.0
 */
@RestController
@Slf4j
public class SendMessageController {

    @Resource
    private IMssageProvider mssageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return mssageProvider.send();
    }
}
