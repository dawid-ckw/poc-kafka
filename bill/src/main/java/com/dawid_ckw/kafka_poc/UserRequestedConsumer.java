package com.dawid_ckw.kafka_poc;

import com.dawid_ckw.avro.MessageRequested;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "Consumer Logger")
public class UserRequestedConsumer {
    final private String topicName = "user.requested";

    @KafkaListener(topics = "user.requested", groupId = "bill-1")
    public void consume(ConsumerRecord<String, MessageRequested> record, Acknowledgment acknowledgment) {
        log.info(String.format("Consumed message -> %s", record.value()));
        
        acknowledgment.acknowledge();
    }
}
