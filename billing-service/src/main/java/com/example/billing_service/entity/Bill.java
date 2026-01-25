package com.example.billing_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@RequiredArgsConstructor

@Entity
public class Bill {

    @Id
    private String billId;
    private String orderId;
    private Double amount;

    private String status;   // PENDING, PAID, FAILED, CANCELLED
    private LocalDateTime createdAt;
    private LocalDateTime paidAt;

}
