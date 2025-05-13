package com.activity.producer;

import com.activity.dto.Employee;
import com.activity.dto.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaAvroProducer {

    @Value("${topic.name}")
    private String topicName;

    @Value("${topic.name2}")
    private String topicName2;

    @Autowired
    private KafkaTemplate<String, Employee> template;

    @Autowired
    private KafkaTemplate<String, Task> templateTask;

    @Autowired
    private KafkaTemplate<String, Object> templateObject;

    public void send(Employee employee){
        CompletableFuture<SendResult<String, Employee>> future =
                template.send(topicName, UUID.randomUUID().toString(),employee);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + employee +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        employee + "] due to : " + ex.getMessage());
            }
        });
    }

    public void sendTask(Task task) {
        CompletableFuture<SendResult<String, Task>> future =
                templateTask.send(topicName2, UUID.randomUUID().toString(),task);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + task +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        task + "] due to : " + ex.getMessage());
            }
        });
    }



}
