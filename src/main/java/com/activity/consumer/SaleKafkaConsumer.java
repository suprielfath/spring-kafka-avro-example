package com.activity.consumer;

import com.activity.dto.SaleDto;
import com.activity.entity.*;
import com.activity.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class SaleKafkaConsumer {
    private final SaleRepository saleRepository;
    private final SaleDetailRepository saleDetailRepository;
    private final ProductRepository productRepository;
    private final FinancialRecordRepository financialRecordRepository;

    @KafkaListener(topics = "${topic.sale}")
    @Transactional
    public void handleSale(SaleDto sale) {
        try {
            log.info("Menerima data penjualan: {}", sale);

            // 3. Buat Financial Record
            Sale savedSale = saleRepository.findById(sale.getId()).orElseThrow();
            FinancialRecord financialRecord = new FinancialRecord();
            financialRecord.setSale(savedSale);
            financialRecord.setTransactionDate(LocalDateTime.now());
            financialRecord.setAmount(new BigDecimal(sale.getTotalAmount()));
            financialRecord.setTransactionType("SALE");
            financialRecord.setPaymentMethod(sale.getPaymentStatus().toString());
            financialRecord.setNotes("Penjualan Invoice: " + sale.getInvoiceNumber());

            financialRecordRepository.save(financialRecord);

            log.info("Penjualan berhasil diproses. Sale ID: {}", savedSale.getId());
        } catch (Exception e) {
            log.error("Error memproses penjualan: {}", e.getMessage());
            throw new RuntimeException("Error memproses data penjualan", e);
        }
    }
}