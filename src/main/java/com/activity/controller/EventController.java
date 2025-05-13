package com.activity.controller;

import com.activity.consumer.KafkaAvroConsumer;
import com.activity.dto.Employee;
import com.activity.dto.Task;
import com.activity.producer.KafkaAvroProducer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EventController {
    @Autowired
    private KafkaAvroProducer producer;

    @Autowired
    private KafkaAvroConsumer consumer;

    @PostMapping("/events")
    public String sendMessage(@RequestBody Employee employee) {
        producer.send(employee);
        return "message published !";
    }

    @PostMapping("/sendTask")
    public String sendTask(@RequestBody Task task) {
        producer.sendTask(task);
        return "message published !";
    }

}
