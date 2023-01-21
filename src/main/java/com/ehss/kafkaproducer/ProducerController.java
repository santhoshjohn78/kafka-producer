package com.ehss.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public static final String TOPICNAME = "test";

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable  String message){
        kafkaTemplate.send(TOPICNAME,message);
        return "Published successfully";
    }
}
