package com.dawid_ckw.kafka_poc;



import com.dawid_ckw.avro.MessageRequested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private KafkaTemplate<String, MessageRequested> messageProducer;

    @GetMapping("/me")
    public UserResponse me() {
        this.messageProducer.send("user.requested", new MessageRequested("Dawid", 20));
        return new UserResponse(1, "Dawid");
    }
}
