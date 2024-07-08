package com.dawid_ckw.kafka_poc.Config;

import com.dawid_ckw.avro.MessageRequested;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopics {
   public final static String TOPIC_USER_REQUESTED = "user.requested";
    public final static String TOPIC_API_NAMETOLOWERCASE = "api.nametolowercase";
    public final static String TOPIC_API_NAMETOLOWERCASE_RESPONSE = "api.nametolowercase-response";
}