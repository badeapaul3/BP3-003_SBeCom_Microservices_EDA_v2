package com.demo.consumer;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author Paul Badea
// **/
//@Component
//public class KafkaConsumer {
//
////    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
////    public void listen1(String message){
////        System.out.println("Received message 1: " + message);
////    }
////
////    @KafkaListener(topics = "my-topic", groupId = "my-new-group")
////    public void listen2(String message){
////        System.out.println("Received message 2: " + message);
////    }
//
//    @KafkaListener(topics = "my-topic-new", groupId = "my-group-3")
//    public void consume(RiderLocation riderLocation) {
//        System.out.println("Received: " + riderLocation.getRiderId());
//    }
//
//
//}
