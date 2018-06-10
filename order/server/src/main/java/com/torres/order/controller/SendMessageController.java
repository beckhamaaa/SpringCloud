package com.torres.order.controller;

import com.torres.order.dto.OrderDTO;
import com.torres.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * stream发送消息
 * Created by Torres
 * 2018-06-10 21:39
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process(){
        String message="now"+new Date();
//        发送消息
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }

    /**
     * 发送 orderDTO对象
     */
    @GetMapping("/sendMessage")
    public void processOrder(){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
