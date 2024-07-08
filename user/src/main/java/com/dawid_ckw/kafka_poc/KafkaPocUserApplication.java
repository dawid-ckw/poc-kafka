package com.dawid_ckw.kafka_poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;

import static com.dawid_ckw.kafka_poc.Config.KafkaTopics.TOPIC_API_NAMETOLOWERCASE;

@EnableKafka
@SpringBootApplication
public class KafkaPocUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPocUserApplication.class, args);
    }


}
