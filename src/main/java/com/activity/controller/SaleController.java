package com.activity.controller;

import com.activity.dto.ApiResponse;
import com.activity.dto.SaleDto;
import com.activity.response.SaleResponse;
import com.activity.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class SaleController {
    private final SaleService saleService;

    @PostMapping("/sales")
    public ResponseEntity<ApiResponse> createSale(@RequestBody SaleDto sale) {
        SaleDto savedSale = saleService.createSale(sale);
        log.info("result createSale: {}", savedSale);
        SaleResponse response = SaleResponse.fromDto(savedSale);
        return ResponseEntity.ok(new ApiResponse(
                true,
                "Penjualan berhasil disimpan",
                response
        ));
    }
}