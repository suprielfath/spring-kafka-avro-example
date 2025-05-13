package com.activity.response;

import com.activity.dto.SaleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponse {
    private Long id;
    private String invoiceNumber;
    private String saleDate;
    private Double totalAmount;
    private String paymentStatus;
    private String customerName;
    private List<SaleDetailResponse> saleDetails;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SaleDetailResponse {
        private Long productId;
        private Integer quantity;
        private Double unitPrice;
    }

    public static SaleResponse fromDto(SaleDto dto) {
        if (dto == null) return null;

        return SaleResponse.builder()
                .id(dto.getId())
                .invoiceNumber(dto.getInvoiceNumber().toString())
                .saleDate(dto.getSaleDate().toString())
                .totalAmount(dto.getTotalAmount())
                .paymentStatus(dto.getPaymentStatus().toString())
                .customerName(dto.getCustomerName().toString())
                .saleDetails(dto.getSaleDetailDto().stream()
                        .map(detail -> SaleDetailResponse.builder()
                                .productId(detail.getProductId())
                                .quantity(detail.getQuantity())
                                .unitPrice(detail.getUnitPrice())
                                .build())
                        .toList())
                .build();
    }
}