package com.stackroute.kafka.springbootkafkaproducerexample.listener;

import com.stackroute.kafka.springbootkafkaproducerexample.model.User;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example1", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example1";

    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }


    public String postservice(String name)
    {
        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }





}
