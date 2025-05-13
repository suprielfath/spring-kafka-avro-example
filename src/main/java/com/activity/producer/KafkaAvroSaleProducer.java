package com.activity.producer;

import com.activity.dto.SaleDto;
import com.activity.entity.Sale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class KafkaAvroSaleProducer {

    @Value("${topic.sale}")
    private String saleTopic;

    @Autowired
    private KafkaTemplate<String, SaleDto> kafkaTemplate;

    public void sendSale(SaleDto sale) {
        String key = UUID.randomUUID().toString();
        CompletableFuture<SendResult<String, SaleDto>> future =
                kafkaTemplate.send(saleTopic, key, sale);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Penjualan berhasil dikirim! Sale ID: {}, Offset: {}",
                        sale.getId(),
                        result.getRecordMetadata().offset());
            } else {
                log.error("Gagal mengirim data penjualan: {}", ex.getMessage());
                throw new RuntimeException("Error mengirim penjualan ke Kafka", ex);
            }
        });
    }
}