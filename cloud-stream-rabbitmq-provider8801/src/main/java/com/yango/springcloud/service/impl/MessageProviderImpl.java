package com.yango.springcloud.service.impl;

import com.yango.springcloud.service.IMssageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description TODO
 * @Author lugq
 * @Email lugq@yango.com.cn
 * @Date 2021/2/17 0017 19:40
 * @Version 1.0
 */
@EnableBinding(Source.class) //指通道channel和exchange绑定在一起,定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMssageProvider {

    @Resource
    private MessageChannel output; //消息发送通道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("+++++++++++++++serial:" +serial);
        return serial;
    }
}
