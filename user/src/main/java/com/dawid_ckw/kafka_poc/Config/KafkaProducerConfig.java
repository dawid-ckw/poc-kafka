package com.dawid_ckw.kafka_poc.Config;

import com.dawid_ckw.avro.MessageRequested;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Bean
    public ProducerFactory<String, MessageRequested> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, MessageRequested> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, String> ProducerFactoryResponseRequest() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplateReplyResponse() {
        return new KafkaTemplate<String, String>(ProducerFactoryResponseRequest());
    }

    @Bean
    public ReplyingKafkaTemplate<String, String, String> replyingTemplate(ProducerFactory<String, String> pf,
                                                                    ConcurrentKafkaListenerContainerFactory<String, String> factory) {

        ConcurrentMessageListenerContainer<String, String> replyContainer =
                factory.createContainer(KafkaTopics.TOPIC_API_NAMETOLOWERCASE_RESPONSE);
        replyContainer.getContainerProperties().setGroupId("so53151961.reply");
        ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate = new ReplyingKafkaTemplate<>(pf, replyContainer);
        return replyingKafkaTemplate;
    }

    @Bean
    public KafkaTemplate<String, String> replyTemplate(ProducerFactory<String, String> pf,
                                                    ConcurrentKafkaListenerContainerFactory<String, String> factory) {

        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(pf);
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