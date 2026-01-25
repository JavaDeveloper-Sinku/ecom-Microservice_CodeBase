package com.example.billing_service.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BillResponse {

    private String billId;
    private String orderId;
    private Double amount;
    private String status;

    private LocalDateTime createdAt;

}
