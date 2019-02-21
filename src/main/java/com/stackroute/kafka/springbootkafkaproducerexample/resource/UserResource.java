package com.stackroute.kafka.springbootkafkaproducerexample.resource;

import com.stackroute.kafka.springbootkafkaproducerexample.listener.KafkaConsumer;
import com.stackroute.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    private KafkaConsumer kafkaConsumer;


    private static final String TOPIC = "Kafka_Example1";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {
        return kafkaConsumer.postservice(name);

    }

//    @GetMapping("/publish/{name}")
//    public String postJason(@PathVariable("name") final String name) {
//
//        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));
//
//        return "Published successfully";
//    }
}
