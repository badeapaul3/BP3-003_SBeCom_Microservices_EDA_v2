package com.demo.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * @author Paul Badea
 **/

@Configuration
public class KafkaConsumerNew {
    @Bean
    public Consumer<RiderLocation> processRiderLocation() {
        return riderLocation -> {
            System.out.println("Received: " + riderLocation.getRiderId() + " @ " + riderLocation.getLatitude() + " " + riderLocation.getLongitude());
        };
    }

    @Bean
    public Consumer<String> processRiderStatus() {
        return status -> {
            System.out.println("Received: " + status);
        };
    }

}
