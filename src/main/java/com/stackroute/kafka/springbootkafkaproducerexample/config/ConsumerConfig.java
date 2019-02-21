package com.stackroute.kafka.springbootkafkaproducerexample.config;

import com.stackroute.kafka.springbootkafkaproducerexample.model.User;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class ConsumerConfig {


        @Bean
        public ConsumerFactory<String, String> consumerFactory () {
            Map<String, Object> config = new HashMap<>();

            config.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.239.144:9092");
            config.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "group_id");
            config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            config.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            return new DefaultKafkaConsumerFactory<>(config);
        }


        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory () {
            ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
            factory.setConsumerFactory(consumerFactory());
            return factory;
        }


        @Bean
        public ConsumerFactory<String, User> userConsumerFactory () {
            Map<String, Object> config = new HashMap<>();

            config.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.239.144:9092");
            config.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, "group_json");
            config.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
            config.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
            return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                    new JsonDeserializer<>(User.class));
        }

        @Bean
        public ConcurrentKafkaListenerContainerFactory<String, User> userKafkaListenerFactory () {
            ConcurrentKafkaListenerContainerFactory<String, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
            factory.setConsumerFactory(userConsumerFactory());
            return factory;
        }
    }

