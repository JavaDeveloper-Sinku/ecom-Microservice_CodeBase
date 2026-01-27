package com.example.billing_service.entity;


import com.example.billing_service.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;   // PENDING, PAID, FAILED, CANCELLED

    private LocalDateTime createdAt;
    private LocalDateTime paidAt;

}
