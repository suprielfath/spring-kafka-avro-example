package com.activity.service;

import com.activity.dto.SaleDto;
import com.activity.dto.SaleDetailDto;
import com.activity.entity.Product;
import com.activity.entity.Sale;
import com.activity.entity.SaleDetail;
import com.activity.producer.KafkaAvroSaleProducer;
import com.activity.repository.SaleDetailRepository;
import com.activity.repository.SaleRepository;
import com.activity.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final KafkaAvroSaleProducer kafkaProducer;
    private final SaleDetailRepository saleDetailRepository;

    @Transactional
    public SaleDto createSale(SaleDto sale) {
        sale.setInvoiceNumber(generateInvoiceNumber());
//        sale.setSaleDate(LocalDateTime.now());

        // Update stock
        for (SaleDetailDto detail : sale.getSaleDetailDto()) {
            Product product = productRepository.findById(Long.parseLong(detail.getProductId().toString()))
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStockQuantity() < detail.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            product.setStockQuantity(product.getStockQuantity() - detail.getQuantity());
            productRepository.save(product);
        }

        Sale savedSale = saleRepository.save(dtoToSales(sale));
        for (SaleDetail detail : savedSale.getSaleDetails()) {
            saleDetailRepository.save(detail);
        }

        SaleDto dto = salesToDto(savedSale);
        // Send to Kafka
        log.info("Send to Kafka: {}", dto);
        kafkaProducer.sendSale(dto);
        log.info("return dto from service: {}", dto);
        return dto;
    }

    private String generateInvoiceNumber() {
        return "INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    /**
     * Mengkonversi Sale Entity ke DTO
     */
    private SaleDto salesToDto(Sale sale) {
        SaleDto saleDto = new SaleDto();
        saleDto.setId(sale.getId());
        saleDto.setInvoiceNumber(sale.getInvoiceNumber());
        saleDto.setSaleDate(sale.getSaleDate().toString());
        saleDto.setTotalAmount(sale.getTotalAmount().doubleValue());
        saleDto.setPaymentStatus(sale.getPaymentStatus());
        saleDto.setCustomerName(sale.getCustomerName());

        // Konversi detail penjualan ke DTO
        List<SaleDetailDto> productDtos = sale.getSaleDetails().stream()
                .map(detail -> {
                    SaleDetailDto productDto = new SaleDetailDto();
                    productDto.setProductId(detail.getProduct().getId());
                    productDto.setQuantity(detail.getQuantity());
                    productDto.setUnitPrice(Double.valueOf(detail.getUnitPrice().doubleValue()));
                    return productDto;
                })
                .collect(Collectors.toList());

        saleDto.setSaleDetailDto(productDtos);
        return saleDto;
    }

    /**
     * Mengkonversi Sale DTO ke Entity
     */
    private Sale dtoToSales(SaleDto saleDto) {
        Sale sale = new Sale();
        // Jika ID ada, konversi dari string ke Long
        if (saleDto.getId() != null) {
            sale.setId(Long.valueOf(saleDto.getId()));
        }
        sale.setInvoiceNumber((String)saleDto.getInvoiceNumber());
        sale.setSaleDate(LocalDateTime.parse(saleDto.getSaleDate()));
        sale.setTotalAmount(BigDecimal.valueOf(saleDto.getTotalAmount()));
        sale.setPaymentStatus((String)saleDto.getPaymentStatus());
        sale.setCustomerName((String)saleDto.getCustomerName());

        // Konversi product DTO ke SaleDetail entity
        List<SaleDetail> saleDetails = saleDto.getSaleDetailDto().stream()
                .map(productDto -> {
                    SaleDetail detail = new SaleDetail();
                    Product product = new Product();
                    product.setId(Long.valueOf(productDto.getProductId()));
                    detail.setProduct(product);
                    detail.setQuantity(productDto.getQuantity());
                    detail.setUnitPrice(new BigDecimal(productDto.getUnitPrice()));
                    detail.setSubtotal(BigDecimal.valueOf(productDto.getUnitPrice()).multiply(BigDecimal.valueOf(productDto.getQuantity())));
                    detail.setSale(sale);
                    return detail;
                })
                .collect(Collectors.toList());

        sale.setSaleDetails(saleDetails);
        return sale;
    }
}