package com.demo.producer;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Paul Badea
// **/
//
//@RestController
//@RequestMapping("/api")
//public class KafkaProducer {
//
//    private final KafkaTemplate<String, RiderLocation> kafkaTemplate;
//
//    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//
//    @PostMapping("/send")
//    public String sendMessage(@RequestParam String message){
//        RiderLocation location = new RiderLocation("rider123", 28.51, 77.65);
//        kafkaTemplate.send("my-topic-new", location);
//        return "Message sent successfully: " + location.getRiderId();
//    }
//}
