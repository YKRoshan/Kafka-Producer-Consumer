package com.stackroute.kafka.springbootkafkaproducerexample.config;

import com.stackroute.kafka.springbootkafkaproducerexample.model.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {




    @Bean
    public ProducerFactory<String, User> producerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.239.144:9092");
        config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }


    @Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
//
//    @Bean
//    public void callConsumer(){
//        consumerConfig.consumerFactory();
//        consumerConfig.kafkaListenerContainerFactory();
//        consumerConfig.userConsumerFactory();
//        consumerConfig.userKafkaListenerFactory();
//    }
}
