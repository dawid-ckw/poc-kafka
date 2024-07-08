package com.dawid_ckw.kafka_poc;

import com.dawid_ckw.avro.MessageRequested;
import com.dawid_ckw.avro.StringToUpper;
import com.dawid_ckw.kafka_poc.Config.KafkaTopics;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
public class UserController {

    @Autowired
    private KafkaTemplate<String, MessageRequested> messageProducer;

    @Autowired
    private ReplyingKafkaTemplate<String, StringToUpper, String> apiTemplate;

    @GetMapping("/me")
    public UserResponse me() throws ExecutionException, InterruptedException, TimeoutException {
        //Request - response example
        ProducerRecord<String, StringToUpper> record = new ProducerRecord<>(KafkaTopics.TOPIC_API_NAMETOLOWERCASE, null, "key", new StringToUpper("my lower letter", 2));
        RequestReplyFuture<String, StringToUpper, String> future =  apiTemplate.sendAndReceive(record);
        String lowerCase = future.get(10, TimeUnit.SECONDS).value();
        System.out.println(lowerCase);

        // simple event
        this.messageProducer.send(KafkaTopics.TOPIC_USER_REQUESTED, new MessageRequested("Dawid", 20));
        return new UserResponse(1, "Dawid" + lowerCase);
    }
}
