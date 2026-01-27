package com.example.billing_service.dto;


import com.example.billing_service.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BillResponse {

    private String billId;
    private String orderId;
    private Double amount;

    private PaymentStatus status;   // enum instead of String

    private LocalDateTime createdAt;

}
