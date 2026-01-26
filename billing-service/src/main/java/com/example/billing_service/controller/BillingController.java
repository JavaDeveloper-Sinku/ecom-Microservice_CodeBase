package com.example.billing_service.controller;


import com.example.billing_service.dto.BillResponse;
import com.example.billing_service.dto.CreateBillRequest;
import com.example.billing_service.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping("/create")
    public BillResponse createBill(@RequestBody CreateBillRequest request) {
        return billingService.createBill(request);
    }

    @GetMapping("/{billId}")
    public BillResponse getBill(@PathVariable String billId) {
        return billingService.getBill(billId);
    }

    @GetMapping
    public String healthCheck() {
        return "Billing Service is UP";
    }
}
