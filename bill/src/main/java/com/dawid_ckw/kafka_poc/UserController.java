package com.dawid_ckw.kafka_poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  
    @GetMapping("/bills")
    public UserResponse me(){
        return new UserResponse(1, "BILL");
    }
}
