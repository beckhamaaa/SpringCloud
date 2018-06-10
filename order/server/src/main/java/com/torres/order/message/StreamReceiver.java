package com.torres.order.message;

import com.torres.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * stream接收消息
 * Created by Torres
 * 2018-06-10 21:36
 */
@Component
@EnableBinding(StreamClient.class)
//绑定
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    public void process(Object message){
      log.info("StreamReceiver:{}"+message);
    }

    /**
     * 接收orderDTO对象
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT2)
    public String processOrder(OrderDTO message){
        log.info("StreamReceiver:{}"+message);
        return "received.";
    }

    /**
     *
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
    public void processOrder(String message){
        log.info("StreamReceiver2:{}"+message);
    }
}
