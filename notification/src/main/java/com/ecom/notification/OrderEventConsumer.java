package com.ecom.notification;

import com.ecom.notification.payload.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Paul Badea
 **/

@Service
@Slf4j
public class OrderEventConsumer {
    @Bean
    public Consumer<OrderCreatedEvent> orderCreated(){
        return event -> {
            log.info("Received order created even for order {}", event.getOrderId());
            log.info("Received order created even for user ID {}", event.getUserId());
        };
    }



//old
//    @RabbitListener(queues = "${rabbitmq.queue.name}")
//    public void handleOrderEvent(OrderCreatedEvent orderEvent){
//        System.out.println("Received order event: " + orderEvent);
//        long orderId = orderEvent.getOrderId();
//        String status = orderEvent.getStatus().name();
//        System.out.println("Order ID: " + orderId + " Status: " + status);
//
//    }



}
