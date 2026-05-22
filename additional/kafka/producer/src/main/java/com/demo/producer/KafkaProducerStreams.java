package com.demo.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;

import java.util.Random;
import java.util.function.Supplier;

@Configuration
public class KafkaProducerStreams {

    @Bean
    public Supplier<RiderLocation> sendRiderLocation(){
        Random random = new Random();
        return () -> {
            String riderId = "rider" + random.nextInt(2000);
            RiderLocation riderLocation = new RiderLocation(riderId, 28.51, 77.65);
            System.out.println("Sending " + riderLocation.getRiderId());
            return riderLocation;
        };
    }

    @Bean
    public Supplier<Message<String>> sendRiderStatus(){
        Random random = new Random();
        return () -> {
            String riderId = "rider" + random.nextInt(2000);
            String status = random.nextBoolean() ? "Ride started" : "Ride completed";
            System.out.println("Sending " + status);
            return MessageBuilder.withPayload(riderId + " : " + status)
                    .setHeader(KafkaHeaders.KEY, riderId.getBytes())
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
                    .build();
        };
    }




}
