package com.ecom.notification;

import com.ecom.notification.payload.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Paul Badea
 **/

@Service
public class OrderEventConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void handleOrderEvent(OrderCreatedEvent orderEvent){
        System.out.println("Received order event: " + orderEvent);
        long orderId = orderEvent.getOrderId();
        String status = orderEvent.getStatus().name();
        System.out.println("Order ID: " + orderId + " Status: " + status);

    }

}
