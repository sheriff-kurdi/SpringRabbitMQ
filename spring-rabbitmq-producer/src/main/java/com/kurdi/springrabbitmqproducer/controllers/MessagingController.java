package com.kurdi.springrabbitmqproducer.controllers;

import com.kurdi.springrabbitmqproducer.CustomMessage;
import com.kurdi.springrabbitmqproducer.conf.MQConfiguration;
import lombok.Data;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessagingController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/publisher")
    public String publishMessage(@RequestBody CustomMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(MQConfiguration.TOPIC_EXCHANGE, MQConfiguration.ROUTING_KEY, message);

        return "message published";
    }
}
