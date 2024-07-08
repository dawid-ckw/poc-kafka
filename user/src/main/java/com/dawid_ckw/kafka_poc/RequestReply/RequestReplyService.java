package com.dawid_ckw.kafka_poc.RequestReply;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import static com.dawid_ckw.kafka_poc.Config.KafkaTopics.TOPIC_API_NAMETOLOWERCASE;

@Service
public class RequestReplyService {

    @KafkaListener(id = TOPIC_API_NAMETOLOWERCASE, topics = TOPIC_API_NAMETOLOWERCASE)
    @SendTo
    public String handle(String foo) {
        System.out.println("REQUEST-RESPONSE RECEIVED: ");
        System.out.println(foo);
        return foo.toUpperCase();
    }
}
