package com.activity.repository;

import com.activity.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    Sale findByInvoiceNumber(String invoiceNumber);
}