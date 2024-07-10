package com.dawid_ckw.kafka_poc.Config;

import com.dawid_ckw.avro.BillRequest;
import com.dawid_ckw.avro.BillResponse;
import com.dawid_ckw.avro.MessageRequested;
import com.dawid_ckw.avro.StringToUpper;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;

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
                factory.createContainer("bill-user-bills");
        replyContainer.getContainerProperties().setGroupId("so53151961.reply");
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

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        configProps.put("schema.registry.url", "http://localhost:8085");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "bill-api");
        return configProps;
    }
}

