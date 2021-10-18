package com.kurdi.springrabbitmqconsumer;

import com.kurdi.springrabbitmqconsumer.conf.MQConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfiguration.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println(message);
    }
}
