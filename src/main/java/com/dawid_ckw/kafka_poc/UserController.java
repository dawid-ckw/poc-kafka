package com.dawid_ckw.kafka_poc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/me")
    public UserResponse me(){
        return new UserResponse(1, "Bob");
    }
}
