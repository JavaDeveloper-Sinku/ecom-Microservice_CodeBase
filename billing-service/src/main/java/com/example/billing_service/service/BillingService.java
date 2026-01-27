package com.example.billing_service.service;

import com.example.billing_service.dto.BillResponse;
import com.example.billing_service.dto.CreateBillRequest;
import com.example.billing_service.entity.Bill;
import com.example.billing_service.enums.PaymentStatus;
import com.example.billing_service.repository.BillRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        // ✅ default status backend controlled
        bill.setPaymentStatus(PaymentStatus.UNPAID);

        bill.setCreatedAt(LocalDateTime.now());

        Bill saved = billRepository.save(bill);
        return mapToResponse(saved);
    }

    @Transactional
    public void updateStatus(String billId, PaymentStatus newStatus) {

        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        // ✅ idempotent check
        if (bill.getPaymentStatus() == PaymentStatus.PAID) {
            return;
        }

        bill.setPaymentStatus(newStatus);

        if (newStatus == PaymentStatus.PAID) {
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

        // ✅ enum mapped directly
        response.setStatus(bill.getPaymentStatus());

        response.setCreatedAt(bill.getCreatedAt());
        return response;
    }
}
