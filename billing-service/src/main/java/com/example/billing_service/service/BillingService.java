package com.example.billing_service.service;


import com.example.billing_service.dto.BillResponse;
import com.example.billing_service.dto.CreateBillRequest;
import com.example.billing_service.entity.Bill;
import com.example.billing_service.repository.BillRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class BillingService {

    @Autowired
    private BillRepository billRepository;

    public BillResponse createBill(CreateBillRequest request) {

        Bill bill = new Bill();
        bill.setBillId(UUID.randomUUID().toString());
        bill.setOrderId(request.getOrderId());
        bill.setAmount(request.getAmount());
        bill.setStatus("PENDING");
        bill.setCreatedAt(LocalDateTime.now());

        Bill saved = billRepository.save(bill);

        return mapToResponse(saved);
    }

    @Transactional
    public void updateStatus(String billId, String status) {

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        if ("PAID".equals(bill.getStatus())) {
            return; // idempotent
        }

        bill.setStatus(status);

        if ("PAID".equals(status)) {
            bill.setPaidAt(LocalDateTime.now());
        }

        billRepository.save(bill);
    }

    public BillResponse getBill(String billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        return mapToResponse(bill);
    }

    private BillResponse mapToResponse(Bill bill) {
        BillResponse response = new BillResponse();
        response.setBillId(bill.getBillId());
        response.setOrderId(bill.getOrderId());
        response.setAmount(bill.getAmount());
        response.setStatus(bill.getStatus());
        response.setCreatedAt(bill.getCreatedAt());
        return response;
    }
}

