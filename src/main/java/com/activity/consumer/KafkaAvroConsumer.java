package com.activity.consumer;

import com.activity.dto.Employee;
import com.activity.dto.Task;
import com.activity.service.FirstNameService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class KafkaAvroConsumer {

    private FirstNameService firstNameService;

    public KafkaAvroConsumer(FirstNameService firstNameService) {
        this.firstNameService = Objects.requireNonNull(firstNameService);
    }

    @KafkaListener(topics = "${topic.name}")
    public void readEmployee(ConsumerRecord<String, Employee> consumerRecord) {
        String key = consumerRecord.key();
        Employee employee = consumerRecord.value();
        log.info("Avro message received for key : " + key + " value : " + employee.toString());
        log.info("Avro message received first name : "+ employee.getFirstName());

        if(employee.getFirstName().toString().equalsIgnoreCase("*")){
            firstNameService.callService("*");
        }else {
            if (employee.getFirstName().toString().equalsIgnoreCase("Basant")) {
                firstNameService.callService("Basant");
            } else if (employee.getFirstName().toString().equalsIgnoreCase("James")) {
                firstNameService.callService("James");
            } else if (employee.getFirstName().toString().equalsIgnoreCase("Kent")) {
                firstNameService.callService("Kent");
            }
        }

    }


@KafkaListener(topics = "${topic.name}")
public void read(ConsumerRecord<String, Object> consumerRecord) {
    String key = consumerRecord.key();
    Object value = consumerRecord.value();

    if (value instanceof Employee employee) {
        log.info("Avro message received for key : " + key + " value : " + employee.toString());
        log.info("Avro message received first name : " + employee.getFirstName());

        String firstName = employee.getFirstName().toString();

        if ("*".equalsIgnoreCase(firstName)) {
            firstNameService.callService("*");
        } else if ("Basant".equalsIgnoreCase(firstName)) {
            firstNameService.callService("Basant");
        } else if ("James".equalsIgnoreCase(firstName)) {
            firstNameService.callService("James");
        } else if ("Kent".equalsIgnoreCase(firstName)) {
            firstNameService.callService("Kent");
        }
    }else if (value instanceof Task task) {
        log.info("Avro message received for key : " + key + " value : " + task.toString());
        log.info("Avro message received name : " + task.getName());

        String firstName = task.getName().toString();

        if ("*".equalsIgnoreCase(firstName)) {
            firstNameService.callService("*");
        } else if ("Basant".equalsIgnoreCase(firstName)) {
            firstNameService.callService("Basant");
        } else if ("James".equalsIgnoreCase(firstName)) {
            firstNameService.callService("James");
        } else if ("Kent".equalsIgnoreCase(firstName)) {
            firstNameService.callService("Kent");
        }
    }
    else {
        log.warn("Received message of unsupported type: " + value.getClass().getName());
    }
}

}
