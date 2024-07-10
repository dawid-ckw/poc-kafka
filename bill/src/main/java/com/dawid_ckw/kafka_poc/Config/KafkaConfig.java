package com.dawid_ckw.kafka_poc.Config;


import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {


    @Bean
    public ProducerFactory<String, Object> producerFactoryStringToUpper() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplateReplyResponse() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(producerConfigs()));
    }

    @Bean
    public ReplyingKafkaTemplate<String, Object, Object> replyingTemplate(ProducerFactory<String, Object> pf,
                                                                                 ConcurrentKafkaListenerContainerFactory<String, Object> factory) {

        ConcurrentMessageListenerContainer<String, Object> replyContainer =
                factory.createContainer("bill-user-bills-response");
        replyContainer.getContainerProperties().setGroupId("api-bill-group-1");
        return  new ReplyingKafkaTemplate<>(pf, replyContainer);
    }

    @Bean
    public KafkaTemplate<String, Object> replyTemplate(ProducerFactory<String, Object> pf,
                                                       ConcurrentKafkaListenerContainerFactory<String, Object> factory) {

        KafkaTemplate<String, Object> kafkaTemplate = new KafkaTemplate<>(pf);
        factory.setReplyTemplate(kafkaTemplate);
        return kafkaTemplate;
    }


    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configProps.put("schema.registry.url", "http://localhost:8085");
        return configProps;
    }

}

