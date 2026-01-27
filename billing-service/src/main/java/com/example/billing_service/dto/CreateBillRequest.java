package com.example.billing_service.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBillRequest {

    private String orderId;
    private Double amount;

}
