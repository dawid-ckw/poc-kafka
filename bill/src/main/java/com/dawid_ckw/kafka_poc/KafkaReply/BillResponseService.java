package com.dawid_ckw.kafka_poc.KafkaReply;

import com.dawid_ckw.avro.Bill;
import com.dawid_ckw.avro.BillRequest;
import com.dawid_ckw.avro.BillResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Service
public class BillResponseService {


    @KafkaListener(topics = "bill-user-bills", groupId = "bill-api")
    @SendTo
    public BillResponse listen(BillRequest request) throws InterruptedException {

        System.out.println("Received Request for:" + request.getPeriod().toString());

        ArrayList<Bill> bills = new ArrayList<Bill>();
        bills.add(
                new Bill(LocalDate.of(2023, 1, 1),
                        LocalDate.of(2023, 2, 1),
                        243.00)
        );
        bills.add(
                new Bill(LocalDate.of(2023, 2, 1),
                        LocalDate.of(2023, 3, 1),
                        23.30)
                );

        return BillResponse.newBuilder().setChildren(bills).build();
    }

}
